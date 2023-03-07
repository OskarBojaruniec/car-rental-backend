package com.bojaruniec.carrental.login;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")

public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public String login() {
        return "";
    }
}
