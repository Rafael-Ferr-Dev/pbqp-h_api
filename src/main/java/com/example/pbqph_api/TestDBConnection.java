package com.example.pbqph_api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDBConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://193.203.175.35:3306/u246759760_bd";
        String user = "u246759760_rafaelferreira";
        String password = "2zdkY*[Y=N&q";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão estabelecida com sucesso!");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
