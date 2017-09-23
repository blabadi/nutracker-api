package com.bashar.nutracker.rest.api;

import com.bashar.nutracker.core.CoreConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Bashar on 2017-08-27.
 */
@Configuration
@Import(CoreConfig.class)
@ComponentScan(basePackageClasses = {Config.class})
public class Config {
}
