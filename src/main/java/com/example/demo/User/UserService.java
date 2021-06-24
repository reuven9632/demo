package com.example.demo.User;
import com.example.demo.token.ConfirmationToken;
import com.example.demo.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {


    private final String NOT_FOUND_USER_MESSAGE = "Sorry not found user %s on data base; This is Exception!";
    private final UserRepo userRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;
    /**
     * Heare i`m override standart method from spring security
     * UserDetailsService
     * */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo
                .findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format(NOT_FOUND_USER_MESSAGE, username)));
    }

    public String signUpUser(User user){
        boolean userExists = userRepo
                .findByUsername(user.getUsername())
                .isPresent();

        if (userExists) {
            // TODO check of attributes are the same and
            // TODO if email not confirmed send confirmation email.
            throw new IllegalStateException("user with userName " + user.getUsername() + " already exists! Can't add user");
        }

        String encodedPassword = bCryptPasswordEncoder
                .encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepo.save(user);

        String tokenName = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                tokenName,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user
        );
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        // TODO: 08.05.2021 SEND EMAIL

        return tokenName;
    }

    public int enableUser(String username) {
        return userRepo.enableUser(username);
    }

}






























