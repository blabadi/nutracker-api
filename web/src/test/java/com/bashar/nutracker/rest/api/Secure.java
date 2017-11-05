package com.bashar.nutracker.rest.api;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Bashar on 2017-11-05.
 */
@AutoConfigureMockMvc()
@SpringBootTest()
@ActiveProfiles("secure")
//@TestPropertySource("classpath:application.properties")
@ContextConfiguration(classes = {Config.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface Secure {
}
