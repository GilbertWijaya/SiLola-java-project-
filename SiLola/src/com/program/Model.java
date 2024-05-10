package com.program;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Model {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_silola";
    private static final String Username = "root";
    private static final String Password = "";

    private static Connection conn;
    private static Statement stmt;

    public static void connection(){

        try {
            
            conn = DriverManager.getConnection(DB_URL, Username, Password);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
