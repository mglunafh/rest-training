package com.some.projects.rest.training.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.some.projects.rest.training.inventory.repo")
@EntityScan("com.some.projects.rest.training.common")
public class WebApplication {

  public static void main(String[] args) {
    SpringApplication.run(WebApplication.class, args);
  }
}