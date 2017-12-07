package com.bashar.nutracker.rest.api;

import com.bashar.nutracker.core.user.Profile;
import com.bashar.nutracker.core.user.UserService;
import com.bashar.nutracker.rest.vo.RegisterUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Bashar on 2017-11-05.
 */
@RestController
@RequestMapping("/api/user")
public class UserApi {
    @Autowired
    UserService userService;

    @RequestMapping(value="/{name}", method = RequestMethod.GET)
    public com.bashar.nutracker.core.user.User login(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = User.class.cast(auth.getPrincipal());
        System.out.println("user : " + user.getUsername() + " logged in.");
        return userService.getFullInfo(user.getUsername());
    }

    @RequestMapping(value="/", method = RequestMethod.POST)
    public com.bashar.nutracker.core.user.User register(@RequestBody RegisterUserVo u){
        return this.userService.createUser(new com.bashar.nutracker.core.user.User()
            .name(u.name)
            .email(u.email)
            .password(u.password)
        );
    }

    @RequestMapping(value="/{name}/profile", method = RequestMethod.PUT)
    public void updateProfile(@RequestBody Profile profile, @AuthenticationPrincipal User activeUser){
        this.userService.updateProfile(activeUser.getUsername(), profile);
    }
}

