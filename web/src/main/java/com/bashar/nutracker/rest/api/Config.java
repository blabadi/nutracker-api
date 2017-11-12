package com.bashar.nutracker.rest.api;

import com.bashar.nutracker.core.CoreConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Bashar on 2017-08-27.
 */
@Configuration
@Import({CoreConfig.class})
@ComponentScan(basePackageClasses = {Config.class})
public class Config {
}

@Configuration
class WebConfig extends WebMvcConfigurerAdapter {

    @Value("${app.client.allowedOrigin}")
    String allowedClientOrigin;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
            // by default only get, post are allowed
            .allowedMethods("HEAD","GET", "POST", "PUT", "DELETE", "OPTIONS")
            .allowedOrigins(allowedClientOrigin)
            .maxAge(3600);
    }
}



