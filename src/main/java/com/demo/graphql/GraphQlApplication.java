package com.demo.graphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.demo.graphql.*")
@ComponentScan(basePackages = { "com.demo.graphql.*" })
@EntityScan("com.demo.graphql.*")
public class GraphQlApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphQlApplication.class, args);
	}

}
