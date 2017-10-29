package inttest.com.bashar.nutracker.core;

import com.bashar.nutracker.core.repo.api.FoodRepoApi;
import com.bashar.nutracker.core.repo.jpa.FoodRepo;
import org.aspectj.weaver.ast.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.core.MongoOperations;

/**
 * Created by Bashar on 2017-08-27.
 */
@Configuration
@PropertySource("application.inttest.properties")
@ComponentScan(basePackageClasses = {TestConfig.class})
public class TestConfig {

}
