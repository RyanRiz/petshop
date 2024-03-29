/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package petshop.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import raven.toast.Notifications;

/**
 *
 * @author Ryan Rizky
 */
public class Database {
    private static Connection mysqlconfig;
    public static Connection configDB()throws SQLException{
        try{
            String url = "jdbc:mysql://localhost:3306/petshop";
            String user = "root";
            String pass = "";
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            mysqlconfig = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e){
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.BOTTOM_RIGHT, "Failed to connect to database");
        }
        return mysqlconfig;
    }
}
