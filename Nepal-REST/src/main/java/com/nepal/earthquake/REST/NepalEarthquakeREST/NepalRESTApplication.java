package com.nepal.earthquake.REST.NepalEarthquakeREST;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class NepalRESTApplication {
    public static void main(String[] args) {
        SpringApplication.run(NepalRESTApplication.class, args);
    }
}
