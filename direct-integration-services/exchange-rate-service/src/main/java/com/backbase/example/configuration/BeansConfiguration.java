package com.backbase.example.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.IdGenerator;
import org.springframework.util.JdkIdGenerator;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeansConfiguration {

    @Bean(name="customRestTemplate")
    public RestTemplate createRestTemplate() {
        return new RestTemplateBuilder().build();
    }

    @ConditionalOnMissingBean(IdGenerator.class)
    @Bean
    public IdGenerator idGenerator() {
        return new JdkIdGenerator();
    }
}
