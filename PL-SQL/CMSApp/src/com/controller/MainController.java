package com.controller;

import com.enums.IncidentStatus;
import com.enums.IncidentType;
import com.enums.Role;
import com.exception.UserNotFoundException;
import com.model.Incident;
import com.model.User;
import com.service.IncidentService;
import com.service.UserService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserService userService = new UserService();
        IncidentService incidentService = new IncidentService();
        System.out.println("--------CMS: LOGIN----------");
        System.out.println("Enter Username ");
        String username = sc.next();
        System.out.println("Enter Password ");
        String password = sc.next();
        try {
            User user = userService.authenticateUser(username, password);
            System.out.println("Welcome " + user.getUsername() );
            System.out.println("Role is " + user.getRole());
            if(user.getRole().equals(Role.OFFICER)){
                while(true){
                    System.out.println("1. View Incidents"); //incidents for this logged-in user
                    System.out.println("2. Filter Incidents by Status ");
                    System.out.println("3. Enter Incident Details -Insert");

                    System.out.println("0. Exit");
                    int op = sc.nextInt();
                    if(op == 0) break; //exits the while loop
                    switch(op){
                        case 1:
                            // implement view incidents op here. (controller - service - repo )
                            List<Incident> listIncidents  = incidentService.getAllIncidents();
                            break;
                        case 2:
                            System.out.println("Enter the status");
                            String statusVal = sc.next();
                            // implement filter incidents by status here
                            break;
                        case 3:
                            /*
                                fetch officer details(id) based on loggedin username
                                then prepare incident object
                                then do the insert
                            * */
                            // take input
                            try {
                                incidentService.addIncident(user.getUsername(),
                                            IncidentType.THEFT, "details",
                                            IncidentStatus.INITIATED);
                                System.out.println("Incident Added");
                            }
                            catch(SQLException e){
                                System.out.println(e.getMessage());
                            }
                            break;
                    }
                }
            }
            else
            if(user.getRole().equals(Role.STATION_HEAD) ){

            }
        } catch (SQLException | UserNotFoundException e) {
            System.out.println(e.getMessage());
        }

        /* I have this loggedIn user.
            - check role of this user
            - if role IS officer Then load Officer menu
            - if role IS station_head Then load station_head Menu
         */

    }
}
