package com.bashar.nutracker.rest.security;

import com.bashar.nutracker.core.dm.User;
import com.bashar.nutracker.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * Created by Bashar on 2017-11-05.
 */
@Component
public class DBUserDetailService implements UserDetailsService {

    @Autowired
    UserService svc;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = svc.getByName(username);
        return org.springframework.security.core.userdetails.User
                .withUsername(u.getName())
                .accountExpired(!u.isActive())
                .accountLocked(!u.isActive())
                .credentialsExpired(!u.isActive())
                .disabled(!u.isActive())
                .password(u.getPassword())
                .authorities(u.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()))
                .build();
    }
}
