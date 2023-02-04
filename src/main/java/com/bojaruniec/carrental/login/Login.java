package com.bojaruniec.carrental.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@AllArgsConstructor
public class Login {

    private String email;
    private String password;
}
