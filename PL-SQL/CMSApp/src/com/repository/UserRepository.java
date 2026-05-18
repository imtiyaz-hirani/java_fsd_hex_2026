package com.repository;

import com.enums.Role;
import com.exception.UserNotFoundException;
import com.model.User;
import com.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {

    public User authenticateUser(String username, String password) throws SQLException {
        System.out.println("DB Conn Object at " + DBConnection.getInstance());
        Connection connection = DBConnection.getInstance().dbConnect();
        String sql = "select * from users where username = ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);

        ResultSet rst = preparedStatement.executeQuery();
        if(rst.next()){
            int id =  rst.getInt("id");
            String username1 = rst.getString("username");
            String password1 = rst.getString("password");
            Role role  = Role.valueOf(rst.getString("role").toUpperCase()) ;
            User user = new User(id,username1,password1,role);
            DBConnection.getInstance().dbClose();
            return user;
        }
        else{
            DBConnection.getInstance().dbClose();
            throw new UserNotFoundException("Invalid Credentials");
        }

    }
}
