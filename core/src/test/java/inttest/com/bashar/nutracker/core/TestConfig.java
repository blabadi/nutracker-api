package inttest.com.bashar.nutracker.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Bashar on 2017-08-27.
 */
@Configuration
@PropertySource("application.inttest.properties")
@ComponentScan(basePackageClasses = {TestConfig.class})
public class TestConfig {

}
