package com.bojaruniec.carrental.registration;

import com.bojaruniec.carrental.users.User;
import com.bojaruniec.carrental.users.UserRepository;
import com.bojaruniec.carrental.users.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final UserService userService;
    private final UserRepository userRepository;

    public User registerNewUser(Registration registration) {

        boolean isEmailOccupied = userRepository
                .findByEmail(registration.getEmail())
                .isPresent();

        if (isEmailOccupied) throw new IllegalArgumentException("Email is occupied");

        return userService.addUser(new User(
                registration.getEmail(),
                registration.getPassword(),
                registration.getName(),
                registration.getSurname()
        ));
    }
}
