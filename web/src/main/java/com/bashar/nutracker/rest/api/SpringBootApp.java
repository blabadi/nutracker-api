package com.bashar.nutracker.rest.api;

import com.bashar.nutracker.rest.security.ApiSecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.Import;

/**
 * Created by Bashar on 2017-09-22.
 */
// the location of this class in the packages is important, because it will scan all sub-packaged classes to
// find spring annotations, and in this case I kept it here to not scan @EnableWebSecurity in the security package
@SpringBootApplication
//manually import the security configs because they are in another package and won't be scanned automatically
@Import(ApiSecurityConfig.class)
@EnableAutoConfiguration(exclude = {
        /*
        * Had to execlude these because spring boot finds the dependencies in class path but no properties defined yet
        * so it complains that i should setup a datasource, and since my data source is setup manually, I don't want
        * spring boot to do that for me so we add these exclusions
        * */
        DataSourceAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class,
})
public class SpringBootApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class);
    }
}
