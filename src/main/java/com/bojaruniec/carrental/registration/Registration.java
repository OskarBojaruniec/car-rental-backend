package com.bojaruniec.carrental.registration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.Pattern;

@Data
@Getter
@AllArgsConstructor
public class Registration {

    @Pattern(regexp = "^(.+)@(\\S+)$")
    private String email;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,32}$")
    private String password;
    private String name;
    private String surname;
}
