package com.repository;

import com.model.Incident;
import com.util.DBConnection;

import java.util.List;

public class IncidentRepository {


    public void insertIncident(Incident incident, int officerId) {
        String sql = "insert into " +
                " incident(officer_id, type, progress_details, status) " +
                " values (?,?,?,?)";
        //jdbc code
    }

    public List<Incident> getAllIncidents() {
        System.out.println("DB Conn Object at " + DBConnection.getInstance());
        DBConnection.getInstance().dbConnect();
        //SQL
        DBConnection.getInstance().dbClose();
        return null;
    }
}
