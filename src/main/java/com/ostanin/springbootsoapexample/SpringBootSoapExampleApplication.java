package com.ostanin.springbootsoapexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootSoapExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSoapExampleApplication.class, args);
	}

}
