package com.service;

import com.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OfficerService {

    public int getOfficerId(String username) throws SQLException {
        String sql="select o.id from officer o " +
                " JOIN users u ON o.users_id = u.id " +
                " where u.username =?";
        Connection connection = DBConnection.getInstance().dbConnect();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        ResultSet rst = preparedStatement.executeQuery();
        int id=0;
        while(rst.next()){
            id = rst.getInt("id");
        }
        DBConnection.getInstance().dbClose();
        return id;
    }
}
