package com.task.payload;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {

    private int id;

    @NotBlank(message = "Username is mandatory")
    private String username;

    @Email(message = "Enter a valid email")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 6, max = 16, message = "Password should have at least 6 characters")
    private String password;

}
