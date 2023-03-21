package com.bojaruniec.carrental.users;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;
    private String email;
    private String password;
    private String name;
    private String surname;

    private UserRole roles;

    public User(String email, String password, String name, String surname, UserRole role) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.roles = role;
    }
}
