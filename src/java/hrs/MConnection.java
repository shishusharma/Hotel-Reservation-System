package hrs;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MConnection {

    static Connection con = null;

    

    public MConnection() {

        try {
            Class.forName(Constants.dbClass).newInstance();
            con = DriverManager.getConnection(Constants.dbUrl,Constants.dbUser,Constants.dbPwd);
        } catch (Exception e) {
        }

    }

    public Connection getConnection() {

        return con;

    }
}