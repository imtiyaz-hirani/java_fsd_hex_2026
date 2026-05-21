package com.app;

import com.app.config.AppConfig;
import com.app.dao.IncidentDao;
import com.app.dao_impl.IncidentDaoImpl;
import com.app.enums.IncidentStatus;
import com.app.enums.IncidentType;
import com.app.exceptions.ResourceNotFoundException;
import com.app.model.Incident;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
        Scanner sc = new Scanner(System.in);

        IncidentDao incidentDao = context.getBean(IncidentDaoImpl.class);
        //incidentDao.insert(new Incident(IncidentType.ABUSE, "incident details", IncidentStatus.ACTIVE));

        System.out.println("Enter Id to delete incident");
        int id = sc.nextInt();
        try {
            incidentDao.deleteById(id);
        }
        catch(ResourceNotFoundException e){
            System.out.println(e.getMessage());
        }
        sc.close();
        context.close();
    }
}
