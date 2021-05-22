package com.swcir.swcirsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.swcir.swcirsystem.Controllers")
@EntityScan("com.swcir.swcirsystem.Models")
@EnableJpaRepositories("com.swcir.swcirsystem.Repositories")
public class SwcirSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwcirSystemApplication.class, args);
	}

}
