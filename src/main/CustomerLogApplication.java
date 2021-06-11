package com.suswagata.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.suswagata.Customer_Log","com.suswagata.Customer_Log.rest","com.suswagata.Customer_Log.repository"})
@EntityScan("com.suswagata.Customer_Log.dto")
@EnableJpaRepositories("com.suswagata.Customer_Log.repository")
public class CustomerLogApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerLogApplication.class, args);
	}

}
