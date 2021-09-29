package com.example.demo.registration;

import com.example.demo.User.User;

import java.util.function.Function;

import static com.example.demo.registration.RegistrationValidator.*;
import static com.example.demo.registration.RegistrationValidator.RegistrationUserValidatorResult.*;

public interface RegistrationValidator extends Function<User, RegistrationUserValidatorResult> {

    static RegistrationValidator isUserNameValid() {
        return user -> user.getUsername().length() > 2 ? SUCCESS : USER_NAME_IS_NOT_VALID;
    }

    static RegistrationValidator isEmailValid() {
        return user -> user.getEmail().contains("@") ? SUCCESS : USER_EMAIL_IS_NOT_VALID;
    }

    static RegistrationValidator isPasswordValid() {
        return user -> user.getPassword().contains("@") ? SUCCESS : USER_PASSWORD_IS_NOT_VALID;
    }

    default RegistrationValidator and(RegistrationValidator other){
        return user -> {
            RegistrationUserValidatorResult result = this.apply(user);
            return result.equals(SUCCESS) ? other.apply(user) : result;
        };
    }


    enum RegistrationUserValidatorResult{
        SUCCESS,
        USER_NAME_IS_NOT_VALID,
        USER_EMAIL_IS_NOT_VALID,
        USER_PASSWORD_IS_NOT_VALID
    }

}
