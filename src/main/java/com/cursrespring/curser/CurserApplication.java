package com.cursrespring.curser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class CurserApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurserApplication.class, args);
	}

}
