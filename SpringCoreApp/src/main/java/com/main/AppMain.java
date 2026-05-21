package com.main;

import com.main.config.AppConfig;
import com.main.model.Insurance;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {
    public static void main(String[] args) {
        System.out.println("Spring Framework");
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        /*
        In your context, search for Insurance Bean and give me object
        * */
        Insurance insurance = context.getBean(Insurance.class); // IOC
        insurance.details();
        context.close();
    }
}
