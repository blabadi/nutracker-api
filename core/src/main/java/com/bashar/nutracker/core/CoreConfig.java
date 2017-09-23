package com.bashar.nutracker.core;

import com.bashar.nutracker.core.repo.mongo.MongoConfig;
import com.bashar.nutracker.core.service.FoodSvc;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Bashar on 2017-08-27.
 */
@Configuration
@Import(MongoConfig.class)
@ComponentScan(basePackageClasses = {FoodSvc.class})
public class CoreConfig {

}
