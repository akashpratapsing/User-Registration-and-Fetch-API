package com.task.controller;

import com.task.entity.User;
import com.task.payload.UserDTO;
import com.task.exception.ResourceNotFoundException;
import com.task.repository.UserRepository;
import com.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    UserRepository userRepository;

    // Register api
    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@Validated @RequestBody UserDTO userDTO) throws Exception {

            UserDTO registeredUser = this.userService.registerUser(userDTO);
            return ResponseEntity.ok(registeredUser);

    }

    // fetch user detail api
    @GetMapping("/fetch")
    public ResponseEntity<UserDTO> fetchUser(@RequestParam String username) {
        return this.userService.getUserByUsername(username)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
    }
}
