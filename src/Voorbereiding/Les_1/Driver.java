package Voorbereiding.Les_1;

import java.sql.*;

public class Driver {

    private static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/xe";
    private static final String DB_USER = "Eline";
    private static final String DB_PASS = "Dennis2018";

    public static void main(String[] args) {

        try {
            //Get a connection to the database
            Connection myConn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);

            String query = "SELECT ? from medewerkers";
            PreparedStatement pstmt = myConn.prepareStatement(query);
            pstmt.setString(1, "*");
            pstmt.executeQuery();






        } catch (SQLException e) {
            e.printStackTrace();

        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
