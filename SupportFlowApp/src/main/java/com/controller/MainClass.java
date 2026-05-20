package com.controller;

import com.config.HibernateConfig;
import com.enums.Priority;
import com.enums.Status;
import com.exception.ResourceNotFoundException;
import com.model.Ticket;
import com.model.User;
import com.service.AuthService;
import com.service.TicketService;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Session session =  HibernateConfig.getSessionFactory().openSession();

        Scanner sc = new Scanner(System.in);
        TicketService ticketService = new TicketService(session);
        AuthService authService = new AuthService(session);

        System.out.println("----------SupportFlow: LOGIN---------");
        System.out.println("Enter Username ");
        String username = sc.next();
        System.out.println("Enter Password ");
        String password = sc.next();
        // go to service and authenticate these credentials and fetch User details(CUSTOMER / EXECUTIVE / ADMIN)
        /*
        * If(role == CUSTOMER)
        *   Ticket
        * */
        try {
            User user = authService.login(username, password);
            switch(user.getRole().toString()){
                case "CUSTOMER":
                    System.out.println("Customer Menu");
                    
                    break;
                case "EXECUTIVE":
                    break;
                case "HR":
                    break;
                default:
                    break;
            }
        }
        catch(NoResultException e){
            System.out.println("Invalid Credentials");
        }
        sc.close();
        session.close();

    }
}
