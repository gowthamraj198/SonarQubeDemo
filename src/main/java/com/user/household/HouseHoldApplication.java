package com.user.household;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityListeners;

@SpringBootApplication
@ComponentScan(basePackages = {"com.user"})
@EntityScan("com.user.model")
@EnableJpaRepositories("com.user.repository")
public class HouseHoldApplication {

	public static void main(String[] args) {

		SpringApplication.run(HouseHoldApplication.class, args);
	}

}

