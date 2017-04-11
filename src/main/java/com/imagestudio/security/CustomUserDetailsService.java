package com.imagestudio.security;

import com.imagestudio.model.User;
import com.imagestudio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by alt on 07.04.17.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserService userService;

    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        User user = userService.findByEmail(email);

        if (user == null) throw new UsernameNotFoundException("User with email " + email + " not found");
        return new CustomUserDetails(user);
    }
}