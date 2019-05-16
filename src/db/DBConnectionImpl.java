package db;

import java.sql.*;

public class DBConnectionImpl implements DBConnection {

    private String dbName = "game_login";
    private String dbLogInName = "root";
    private String dbPass = "";

    private Connection connection;

    DBConnectionImpl() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName, dbLogInName, dbPass);
    }

    DBConnectionImpl(String name, String logName, String pass) throws SQLException{
        dbName = name;
        dbLogInName = logName;
        dbPass = pass;
        connection = DriverManager.getConnection("jdbc:mysql://localhost/"+dbName, dbLogInName, dbPass);
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

}
