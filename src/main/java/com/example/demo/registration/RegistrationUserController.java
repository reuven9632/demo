package com.example.demo.registration;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationUserController {

    private final RegistrationUserService registrationUserService;

    @PostMapping
    public String addUser(RegistrationUserRequest userRequest){
        return registrationUserService.registrationUser(userRequest);
    }

@GetMapping(path = "confirm")
    public String confirmToken(@RequestParam(name = "token") String token){
        return registrationUserService.confirmToken(token);
    }


}
