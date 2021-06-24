package com.example.demo.registration;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class RegistrationUserValidator implements Predicate<String> {

    @Override
    public boolean test(String userName) {
        return true;
    }
}
