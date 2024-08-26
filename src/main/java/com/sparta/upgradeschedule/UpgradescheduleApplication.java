package com.sparta.upgradeschedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class UpgradescheduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(UpgradescheduleApplication.class, args);
    }

}
