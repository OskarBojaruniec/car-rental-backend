package com.bojaruniec.carrental.registration;

import com.bojaruniec.carrental.users.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/register")
    public User registerNewUser(@Valid @RequestBody Registration registration) {
        return registrationService.registerNewUser(registration);
    }
}
