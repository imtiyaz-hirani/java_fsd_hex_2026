package com.controller;

import com.config.HibernateConfig;
import com.enums.Priority;
import com.enums.Status;
import com.model.Ticket;
import com.service.TicketService;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Session session =  HibernateConfig.getSessionFactory().openSession();

        Scanner sc = new Scanner(System.in);
        TicketService ticketService = new TicketService(session);

        while(true){
            System.out.println("1. Add Ticket");
            System.out.println("2. Delete Ticket by id");
            System.out.println("3. Fetch all Tickets");
            System.out.println("4. Update Ticket");
            System.out.println("0. Exit ");
            int op = sc.nextInt();
            if(op ==0)
                break;
            switch(op){
                case 1:
                    // Take input or prepare urself
                    Ticket ticket = new Ticket();
                    ticket.setSubject("Internet shutdown");
                    ticket.setDetails("internet not working since yesterday. ");
                    ticket.setStatus(Status.OPEN);
                    ticket.setPriority(Priority.HIGH);
                    ticketService.insert(ticket);
                    System.out.println("Ticket Added");
                    break;
                case 2:
                    break;
                default:
                    System.out.println("invalid option. try again");
                    break;
            }
        }

        sc.close();
        session.close();

    }
}
