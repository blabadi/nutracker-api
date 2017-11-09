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
 * Tests marked with this annoation will use the secure profile and therfore will
 * load security configs in their context
 */
@AutoConfigureMockMvc()
@SpringBootTest()
@ActiveProfiles("secure")
//https://stackoverflow.com/questions/29669393/override-default-spring-boot-application-properties-settings-in-junit-test
//if you want to use a non-default (other than application.properties) name for the test properties file.
//@TestPropertySource("classpath:application.test.properties")
@ContextConfiguration(classes = {Config.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface Secure {
}
