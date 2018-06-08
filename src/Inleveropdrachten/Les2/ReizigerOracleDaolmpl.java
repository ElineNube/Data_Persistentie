package Inleveropdrachten.Les2;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ReizigerOracleDaolmpl extends OracleBaseDAO implements ReizigerDao {

    public Reiziger save(Reiziger reiziger) {
        try {
            Connection conn = getConnection();
            String sql = "INSERT INTO reiziger(REIZIGERID, VOORLETTERS, TUSSENVOEGSEL, ACHTERNAAM) VALUES(?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, reiziger.getId());
            preparedStatement.setString(2, reiziger.getVoorletters());
            preparedStatement.setString(3, reiziger.getTussenvoegsel());
            preparedStatement.setString(4, reiziger.getAchternaam());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return reiziger;
        } catch (SQLException e){
            System.out.println(e);
            return null;
        }
    }

    public List<Reiziger> findAll() {
        try{
            Connection conn = getConnection();
            String sql = "SELECT * FROM reiziger";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Reiziger> list = new ArrayList<>();
            Reiziger reiziger;
            while (resultSet.next()) {
                reiziger = new Reiziger(resultSet.getInt("REIZIGERID"),
                            resultSet.getString("VOORLETTERS"),
                            resultSet.getString("TUSSENVOEGSEL"),
                            resultSet.getString("ACHTERNAAM"),
                            resultSet.getDate("GEBORTEDATUM")
                );
                list.add(reiziger);
            }
            resultSet.close();
            statement.close();
            return list;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Reiziger> findByGBdatum(String geboortedatum) {
        try {
        	SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yy");
        	java.util.Date date = sdf1.parse(geboortedatum);
        	java.sql.Date sqlGBDatum = new java.sql.Date(date.getTime());
       	
        	Connection conn = getConnection();
        	String query = "SELECT * FROM REIZIGER WHERE GEBORTEDATUM = TO_DATE('" + sqlGBDatum + "', 'yyyy-MM-dd')";
        	Statement statement = conn.createStatement();
        	ResultSet resultSet = statement.executeQuery(query);
        	List<Reiziger> list = new ArrayList<>();
        	Reiziger reiziger;
        	while (resultSet.next()) {
                reiziger = new Reiziger(resultSet.getInt("REIZIGERID"),
                            resultSet.getString("VOORLETTERS"),
                            resultSet.getString("TUSSENVOEGSEL"),
                            resultSet.getString("ACHTERNAAM"),
                            resultSet.getDate("GEBORTEDATUM")
                );
                list.add(reiziger);
            }
            resultSet.close();
            statement.close();
            return list;
        	
        } catch(SQLException | ParseException e){
            System.out.println(e.getMessage());
            return null;
        	
        }
    }

    public Reiziger update(Reiziger reiziger) {
    	try {
    			Connection conn = getConnection();
    			 String sql = "Update reiziger "
    			 				+ "SET voorletters = ?,"
    			 				+ "tussenvoegsel = ?,"
    			 				+ "achternaam = ?"
    			 				+ "WHERE reizigerid = ?";
    	            PreparedStatement preparedStatement = conn.prepareStatement(sql);
    	            preparedStatement.setString(1, reiziger.getVoorletters());;
    	            preparedStatement.setString(2, reiziger.getTussenvoegsel());;
    	            preparedStatement.setString(3, reiziger.getAchternaam());;
    	            preparedStatement.setInt(4, reiziger.getId());
    	            preparedStatement.executeUpdate();
    	            preparedStatement.close();
                return reiziger;	
    	} catch(SQLException e) {
    		System.out.println(e.getMessage());
    		return null;
    	}
        
    }

    public boolean delete(Reiziger reiziger) {
    	if (reiziger == null) {
    		throw new IllegalArgumentException("Reiziger mag niet null zijn");
    	} else {
    		try {
       		 Connection conn = getConnection();
       	        String sql = "DELETE FROM reiziger WHERE reizigerid = " + reiziger.getId();
       	        Statement statement = conn.createStatement();
       	        statement.executeUpdate(sql);
       	        boolean result = true;
       	        return result;
       	} catch(SQLException e) {
       		System.out.println(e.getMessage());
       		return false;
       	}     
       }
    }
                	
}
