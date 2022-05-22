package com.example.spring2.configurations;

import com.example.spring2.model.ExceptionMessage;
import com.example.spring2.services.api.CategoryService;
import com.example.spring2.services.impl.CategoryServiceImpl;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
    @Bean()
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    CategoryService categoryService() {
        return new CategoryServiceImpl();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    ExceptionMessage exceptionMessage() {
        return new ExceptionMessage();
    }
}
