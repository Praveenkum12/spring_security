package com.jimmy.springsec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAspectJAutoProxy
@EnableJpaAuditing(auditorAwareRef = "banky-aware-ref")
@EnableJpaRepositories("com.jimmy.springsec.repository")
@EntityScan("com.jimmy.springsec.entity")
@SpringBootApplication
public class SpringsecApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecApplication.class, args);
	}

}
