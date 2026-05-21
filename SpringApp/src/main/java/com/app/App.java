package com.app;

import com.app.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println(context.getBean(DataSource.class));
        context.close();
    }
}
