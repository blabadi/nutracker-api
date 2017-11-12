package com.bashar.nutracker.rest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
 * Created by Bashar on 2017-11-05.
 */

@Profile("secure")
@Configuration
@ComponentScan(basePackageClasses = ApiSecurityConfig.class)
@EnableWebSecurity
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationEntryPoint authEntryPoint;

    @Autowired
    private DBUserDetailService userSvc;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //needed to skip the security for OPTIONS http method that is called before the actual method
        //see: https://docs.spring.io/spring-security/site/docs/4.2.x/reference/html/cors.html
        http.cors()
                .and().csrf().disable()
                .authorizeRequests().antMatchers("/api/user/register").permitAll()
                .and()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .httpBasic().authenticationEntryPoint(authEntryPoint);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("bashar").password("password").roles("ACTUATOR");
        auth.userDetailsService(userSvc).passwordEncoder(new BCryptPasswordEncoder());
    }

}