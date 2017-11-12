package com.bashar.nutracker.rest.api;

import com.bashar.nutracker.core.service.UserService;
import com.bashar.nutracker.rest.vo.LoginInfo;
import com.bashar.nutracker.rest.vo.RegisterUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Created by Bashar on 2017-11-05.
 */
@RestController
@RequestMapping("/api/user")
public class UserApi {
    @Autowired
    UserService userService;
    @RequestMapping(value="/authenticate", method = RequestMethod.GET)
    public LoginInfo login(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = User.class.cast(auth.getPrincipal());
        System.out.println("user : " + user.getUsername() + " logged in.");
        LoginInfo info = new LoginInfo();
        info.name = user.getUsername();
        info.roles = new ArrayList<>();
        info.roles = user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        return info;
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public LoginInfo register(@RequestBody RegisterUserVo u){
        this.userService.createUser(new com.bashar.nutracker.core.dm.User()
            .name(u.name)
            .email(u.email)
            .password(u.password)
        );
        LoginInfo info = new LoginInfo();
        info.name = u.name;
        info.roles = new ArrayList<>();
        info.roles.add("USER");
        return info;
    }

}

