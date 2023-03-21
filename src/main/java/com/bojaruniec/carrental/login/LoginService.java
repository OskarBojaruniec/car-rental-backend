package com.bojaruniec.carrental.login;

import com.bojaruniec.carrental.users.User;
import com.bojaruniec.carrental.users.UserDto;
import com.bojaruniec.carrental.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;


    public UserDto getUser(Login login) {
        User user = userRepository.findByEmail(login.getEmail()).orElseThrow();
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());

        return userDto;
    }
}
