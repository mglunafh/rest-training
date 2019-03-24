package com.some.projects.rest.training.inventory.config;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class JsonConfiguration implements WebMvcConfigurer {

  @Override
  public void configureMessageConverters(
      List<HttpMessageConverter<?>> converters) {

    converters.add(new MappingJackson2HttpMessageConverter(
        new Jackson2ObjectMapperBuilder()
            .propertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE)
            .serializationInclusion(Include.NON_EMPTY)
            .build()
    ));
  }
}

