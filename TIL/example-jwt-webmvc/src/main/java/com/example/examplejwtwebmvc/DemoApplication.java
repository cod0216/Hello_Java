package com.example.examplejwtwebmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan // <<< added
public class DemoApplication {
                                    //네!
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
