package com.project.resturant;

import com.project.resturant.Sitting.TokenConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(TokenConfig.class)
public class ResturantApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResturantApplication.class, args);
    }

}
