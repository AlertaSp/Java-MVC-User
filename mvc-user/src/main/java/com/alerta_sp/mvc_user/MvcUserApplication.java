package com.alerta_sp.mvc_user;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class MvcUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcUserApplication.class, args);
	}

}
