package com.leyou;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LeyouUploadAppliction {
    public static void main(String[] args) {
        SpringApplication.run(LeyouUploadAppliction.class, args);
    }
}
