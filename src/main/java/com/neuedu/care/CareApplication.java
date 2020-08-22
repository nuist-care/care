package com.neuedu.care;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class CareApplication {

	public static void main(String[] args) {
		SpringApplication.run(CareApplication.class, args);
	}

}
