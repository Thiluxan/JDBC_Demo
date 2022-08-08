package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDemo1 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String city = "Sydney";
        String country = "Australia";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3307/demo_db","luxan","luxanmysql");
        String query = "INSERT INTO city VALUES(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,city);
        preparedStatement.setString(2,country);
        int count = preparedStatement.executeUpdate();
        System.out.println(count + " row/s added");
        preparedStatement.close();
        connection.close();
    }
}
