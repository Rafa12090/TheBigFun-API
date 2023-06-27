package com.crackelets.bigfun.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BigFunApplication {

    public static void main(String[] args) {

        SpringApplication.run(BigFunApplication.class, args);
    }


}
