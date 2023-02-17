package com.bojaruniec.carrental.users;

import com.bojaruniec.carrental.config.MyUserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getSingleUser(long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }


}
