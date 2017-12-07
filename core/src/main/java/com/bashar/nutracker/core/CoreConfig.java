package com.bashar.nutracker.core;

import com.bashar.nutracker.core.entry.EntrySvc;
import com.bashar.nutracker.core.repo.config.mongo.MongoConfig;
import com.bashar.nutracker.core.food.FoodSvc;
import com.bashar.nutracker.core.user.UserService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Bashar on 2017-08-27.
 */
@Configuration
@Import(MongoConfig.class)
@ComponentScan(basePackageClasses = {
    FoodSvc.class,
    EntrySvc.class,
    UserService.class
})
public class CoreConfig {

}
