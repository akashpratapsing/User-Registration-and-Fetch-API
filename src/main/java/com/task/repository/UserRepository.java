package com.task.repository;

import com.task.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    // It'll be used when fetching user details by username.
    Optional<User> findByUsername(String username);

    User findByEmail(String email);
}
