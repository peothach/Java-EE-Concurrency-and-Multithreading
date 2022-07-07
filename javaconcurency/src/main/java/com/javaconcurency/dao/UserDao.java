/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javaconcurency.dao;

import com.javaconcurency.beans.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nhthach
 */
public class UserDao {

    public int saveUser(User user) {
        int rows = 0;
        Connection connection = DBConnection.getConnection();
        
        try {
            PreparedStatement statement = connection.prepareStatement("insert into user values(?,?,?)");
            statement.setInt(1, user.getId());
            statement.setString(2, user.getName());
            statement.setString(3, user.getEmailAddress());
            rows = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rows;
    }
}
