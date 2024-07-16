package com.devstack.test.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private Connection connection = null;
    private static DbConnection dbConnection;

    private DbConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/dsmp_3_test","root", "1234"
        );
    }
    public static DbConnection getInstance() throws SQLException, ClassNotFoundException {
        return (dbConnection == null)?dbConnection=new DbConnection():dbConnection;
    }
    public Connection getConnection(){
        return connection;
    }
}
