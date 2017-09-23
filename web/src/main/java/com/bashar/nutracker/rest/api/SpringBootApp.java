package com.bashar.nutracker.rest.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Import;

/**
 * Created by Bashar on 2017-09-22.
 */
@SpringBootApplication
@Import(Config.class)
/*
* Had to execlude these because spring boot finds the dependencies in class path but no properties defined yet
* so it complains that i should setup a datasource, and since my data source is setup manually, I don't want
* spring boot to do that for me so we add these exclusions
* */
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class SpringBootApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class);
    }
}
