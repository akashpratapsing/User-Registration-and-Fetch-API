package com.task.service.impl;

import com.task.payload.UserDTO;
import com.task.entity.User;
import com.task.repository.UserRepository;
import com.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDTO registerUser(UserDTO userDTO) throws Exception {

        User isExist = userRepository.findByEmail(userDTO.getEmail());

        if (isExist != null) {
            throw new Exception("User Already exist with this email !");
        }

        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());

        // password encryption
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        user = this.userRepository.save(user);
        userDTO.setId(user.getId());
        return userDTO;
    }

    @Override
    public Optional<UserDTO> getUserByUsername(String username) {

        return this.userRepository.findByUsername(username).map(user -> {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setUsername(user.getUsername());
            userDTO.setEmail(user.getEmail());
            return userDTO;
        });
    }
}
