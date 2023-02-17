package com.bojaruniec.carrental.registration;

import com.bojaruniec.carrental.config.PasswordEncoder;
import com.bojaruniec.carrental.users.User;
import com.bojaruniec.carrental.users.UserRepository;
import com.bojaruniec.carrental.users.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final UserService userService;
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    public User registerNewUser(Registration registration) {

        boolean isEmailOccupied = userRepository
                .findByEmail(registration.getEmail())
                .isPresent();

        if (isEmailOccupied) throw new IllegalArgumentException("Email is occupied");

        return userService.addUser(new User(
                registration.getEmail(),
                passwordEncoder.bCryptPasswordEncoder().encode(registration.getPassword()),
                registration.getName(),
                registration.getSurname()
        ));
    }
}
