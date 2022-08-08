package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 1. Import Jar Files
 * 2. Connect to the Driver
 * 3. Create New Connection  - Url(host, port, database name), username, password
 * 4. Create Statement
 * 5. Execute Queries
 * 6. Fetch Results
 * 7. Close the Connections
 */
public class InsertDemo {

    public static void main(String[] args){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection =
                    DriverManager.getConnection("jdbc:mysql://localhost:3307/demo_db","luxan","luxanmysql");
            Statement statement = connection.createStatement();
            String query = "insert into city values ('Jaffna','Sri Lanka')";
            int count = statement.executeUpdate(query);
            System.out.println(count + " row/s added");
            statement.close();
            connection.close();
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        catch (ClassNotFoundException exception){
            exception.printStackTrace();
        }
    }
}
