package com.example.demo.registration;

import com.example.demo.User.UserRole;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class RegistrationUserRequest {

    private String username;
    private String lastName;
    private String email;
    private String password;
    private UserRole role;

}
