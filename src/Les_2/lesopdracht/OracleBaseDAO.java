package lesopdracht;

import java.sql.*;

public class OracleBaseDAO {

    private static final String DB_DRIV = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL = "jdbc:oracle:thin@//localhost:1521/xe";
    private static final String DB_USER = "ov";
    private static final String DB_PASS = "DP2018";
    public static Connection conn;

    protected static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }
}