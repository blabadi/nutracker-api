package com.bashar.nutracker.rest.api;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Bashar on 2017-11-05.
 */
@AutoConfigureMockMvc()
@SpringBootTest()
@ActiveProfiles("insecure")
//https://stackoverflow.com/questions/29669393/override-default-spring-boot-application-properties-settings-in-junit-test
//if you want to use a non-default (other than application.properties) name for the test properties file.
//@TestPropertySource("classpath:application.test.properties")
@ContextConfiguration(classes = {Config.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface Insecure {
}
