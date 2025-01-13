package com.remo.rabbit.config;

import com.remo.rabbit.service.LocalOllamaService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = {"com.remo.rabbit"})
public class AppConfig {

    @Bean
    public LocalOllamaService localOllamaService() {
        return new LocalOllamaService(restTemplate());
    }
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    };

}
