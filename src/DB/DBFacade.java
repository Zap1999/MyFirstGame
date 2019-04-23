package DB;

import java.sql.Connection;
import java.sql.SQLException;

public class DBFacade {

    private String val1;
    private String val2;
    Connection connection;


    public DBFacade(String val1, String val2) {
        this.val1 = val1;
        this.val2 = val2;

        DBConnection conn = null;
        try {
            conn = new DBConnectionProxy();
        }
        catch (SQLException e) {
            System.err.println("SQL connection failed.");
            e.printStackTrace();
        }
        if (conn != null)
            connection = conn.getConnection();

    }

    public boolean logIn() {
        try {
            return new LoginDB(connection, val1, val2).logIn();
        }
        catch (SQLException e) {
            System.err.println("SQL log in check failed.");
            e.printStackTrace();
            return false;
        }
    }

    public boolean register() {
        try {
            return new LoginDB(connection, val1, val2).register();
        }
        catch (SQLException e) {
            System.err.println("SQL registration failed.");
            e.printStackTrace();
            return false;
        }
    }

}


































// unused fields
/*private String table = null;
    private String db = null;*/


// unused methods
/*DBFacade(String val1, String val2, String table) {
        this.val1 = val1;
        this.val2 = val2;
        this.table = table;
    }

    DBFacade(String val1, String val2, String table, String db) {
        this.val1 = val1;
        this.val2 = val2;
        this.table = table;
        this.db = db;
    }*/
