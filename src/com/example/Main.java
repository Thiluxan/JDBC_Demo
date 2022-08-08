package com.example;

import java.sql.*;

/**
 * 1. Import Jar Files
 * 2. Connect to the Driver
 * 3. Create New Connection  - Url(host, port, database name), username, password
 * 4. Create Statement
 * 5. Execute Queries
 * 6. Fetch Results
 * 7. Close the Connections
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3307/demo_db","luxan","luxanmysql");
        Statement statement = connection.createStatement();
        String query = "select * from city";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()){
            System.out.println(resultSet.getString(1) + " - " + resultSet.getString("country"));
        }
        statement.close();
        connection.close();
    }
}