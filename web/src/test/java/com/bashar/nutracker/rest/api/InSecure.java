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
 * uses application-insecure.properties under test/resources to disable boot default security configs
 */
@AutoConfigureMockMvc()
@SpringBootTest()
@ActiveProfiles("insecure")
@ContextConfiguration(classes = {Config.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface Insecure {
}
