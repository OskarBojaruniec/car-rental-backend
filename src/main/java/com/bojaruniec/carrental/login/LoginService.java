package com.bojaruniec.carrental.login;

import com.bojaruniec.carrental.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    public String login(Login login) {
        boolean areCredentialsCorrect = userRepository
                .findByEmailAndPassword(login.getEmail(), login.getPassword())
                .isPresent();

        if (areCredentialsCorrect) return "Logged in";

        return "Wrong email or password";
    }
}
