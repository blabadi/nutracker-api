package com.bashar.nutracker.rest.api;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Bashar on 2017-11-11.
 * The reason I created this annotation is that the web package tests
 * failed when run from gradle.
 * Error was: Spring couldn't auto configure a data source.
 * The reason was that I don't have a database driver in my class path (gradle deps)
 * but I have excluded the auto data source configs from my auto configs in the SpringBootApp
 * which lead me to find out that exclusions don't apply automatically on Tests if you have @ContextConfiguration
 *
 * so I had to remove the @ContextConfiguration, and just let spring boot through @SpringBootTest figure that out.
 *
 */
@AutoConfigureMockMvc()
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@Retention(RetentionPolicy.RUNTIME)
public @interface WebMvcTestContext {
}
