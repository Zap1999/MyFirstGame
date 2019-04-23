package DB;

import java.sql.Connection;
import java.sql.SQLException;

public class DBConnectionProxy implements DBConnection {

    private DBConnectionImpl conn;

    DBConnectionProxy() throws SQLException{
        try {
            conn = new DBConnectionImpl();
        }
        catch (SQLException e) {
            throw e;
        }
    }

    DBConnectionProxy(String name, String logName, String pass) {
        try {
            conn = new DBConnectionImpl(name, logName, pass);
        }
        catch (SQLException e) {
            conn = null;
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() {
        if (conn != null) {
            return conn.getConnection();
        }
        else return null;
    }

}
