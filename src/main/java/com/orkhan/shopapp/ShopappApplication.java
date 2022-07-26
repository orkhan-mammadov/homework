package com.orkhan.shopapp;

import com.orkhan.shopapp.entity.AppUser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.orkhan.shopapp")
@ComponentScan(basePackages = "com.orkhan.shopapp")
@EntityScan("com.orkhan")
@EnableJpaRepositories("com.orkhan")
public class ShopappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopappApplication.class, args);
	}

}
