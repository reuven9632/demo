package com.example.demo.jwt;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserNameAndPasswordAuthenticationRequest {

    private String UserName;

    private String password;

}
