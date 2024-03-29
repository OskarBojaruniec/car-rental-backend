package com.bojaruniec.carrental.login;

import com.bojaruniec.carrental.users.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")

public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public UserDto login(@RequestBody Login login) {
        return loginService.getUser(login);
    }
}
