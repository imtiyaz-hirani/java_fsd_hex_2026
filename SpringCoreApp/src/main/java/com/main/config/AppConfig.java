package com.main.config;

import org.springframework.context.annotation.Configuration;

@Configuration // Auto-loads the class for us
public class AppConfig {

    static{
        System.out.println("App Config class loaded...");
    }
}
