package com.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories("com.repository")
@EntityScan(basePackages={"com.bean"})   
@ComponentScan("com.controller ,com.bean, com.repository, com.service")
public class Client {

	public static void main(String[] args) {
		SpringApplication.run(Client.class, args);
	}

}
