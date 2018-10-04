package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {

    public static void main(String[] args) {
        // Create a variable for the connection string.
        String connectionUrl = "jdbc:sqlserver://localhost:1433;integratedSecurity=true;user=Arkan;password=ddd;";

        // Declare the JDBC objects
        Connection con = null;
        Statement stmt = null, stmt_2 = null;
        ResultSet rs = null, rs_2 = null;

        try {
            //Establish the connection
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            //Create and execute an SQL statement
            String SQL = "SELECT * FROM Arkan.dbo.users";
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);

            String SQL_2 = "SELECT @@SERVERNAME";
            stmt_2 = con.createStatement();
            rs_2 = stmt_2.executeQuery(SQL_2);

            //Iterate thru the data
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }
            while (rs_2.next()){
                System.out.println(rs_2.getString(1));
            }
        }
/*
        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
            String SQL = "SELECT TOP 10 * FROM Person.Contact";
            ResultSet rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                System.out.println(rs.getString("FirstName") + " " + rs.getString("LastName"));
            }
        }
*/
        // Handle any errors that may have occurred.
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

