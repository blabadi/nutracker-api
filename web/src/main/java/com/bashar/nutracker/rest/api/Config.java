package com.bashar.nutracker.rest.api;

import com.bashar.nutracker.core.CoreConfig;
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
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                // todo: make configurable
                .allowedOrigins("http://localhost:4200")
//                .allowCredentials(false)
                .maxAge(3600);
    }
}



