package com.bashar.nutracker.rest.api;

import com.bashar.nutracker.rest.vo.LoginInfo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Created by Bashar on 2017-11-05.
 */
@RestController()
@CrossOrigin(origins = "*")
@RequestMapping("user")
public class UserApi {

    @RequestMapping(value="/authenticate", method = RequestMethod.GET)
    public LoginInfo login(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = User.class.cast(auth.getPrincipal());
        System.out.println("user : " + user.getUsername() + " logged in.");
        LoginInfo info = new LoginInfo();
        info.username = user.getUsername();
        info.roles = new ArrayList<>();
        info.roles = user.getAuthorities().stream().map(a -> a.getAuthority()).collect(Collectors.toList());
        return info;
    }
}

