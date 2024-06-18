package com.task.service;

import com.task.payload.UserDTO;

import java.util.Optional;

public interface UserService {

    UserDTO registerUser(UserDTO userDTO) throws Exception;

    Optional<UserDTO> getUserByUsername(String username);
}
