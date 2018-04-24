package P1;

import java.sql.*;

public class Driver {

    private static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/xe";
    private static final String DB_USER = "Eline";
    private static final String DB_PASS = "Dennis2018";

    public static void main(String[] args) {

        try {
            //Get a connection to the database
            Connection myConn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);

            //Create a statement
            Statement myStat = myConn.createStatement();

            //Execute a SQL query
            ResultSet myRs = myStat.executeQuery("SELECT * FROM medewerkers");

            //Process the result set
            while (myRs.next()) {
                System.out.println(myRs.getString("voorl") + ", " + myRs.getString("naam"));
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
