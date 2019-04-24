package com.sinosoft.drools.droolsrestdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations = "classpath:/drools-config.xml")
@ComponentScan("com.sinosoft.drools.droolsrestdemo")
@EnableAutoConfiguration
public class DroolsrestdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DroolsrestdemoApplication.class, args);
    }

}
