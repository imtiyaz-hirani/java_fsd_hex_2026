package com.app;

import com.app.config.AppConfig;
import com.app.dao.IncidentDao;
import com.app.dao_impl.IncidentDaoImpl;
import com.app.enums.IncidentStatus;
import com.app.enums.IncidentType;
import com.app.model.Incident;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);

        IncidentDao incidentDao = context.getBean(IncidentDaoImpl.class);
        incidentDao.insert(new Incident(IncidentType.ABUSE, "incident details", IncidentStatus.ACTIVE));

        context.close();
    }
}
