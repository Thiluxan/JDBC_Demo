package com.example;

import java.sql.*;

public class ReadDemo {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String country = "Sri Lanka";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3307/demo_db","luxan","luxanmysql");
        String query = "select * from city where country = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,country);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("city") + " - " + resultSet.getString(2));
        }
        preparedStatement.close();
        connection.close();
    }
}
