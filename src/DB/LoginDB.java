package DB;

import java.sql.*;


public class LoginDB {

    private Connection connection;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private String dbTable = "login_data";


    String username;
    String password;

    LoginDB(Connection conn, String user, String pass) {
        connection = conn;
        username = user;
        password = pass;
    }


    boolean logIn() throws SQLException{
        String sql = "select * from " + dbTable + " where username=? and password=?";
            exec(sql);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) return true;
            else return false;
    }

    boolean register() throws SQLException{
        String sql = "insert into " + dbTable + "(username, password) values (?, ?)";
            exec(sql);
            int i = preparedStatement.executeUpdate();
            if (i == 1)
                return true;
            else return false;
    }

    private void exec(String sql) throws SQLException {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
    }

}
