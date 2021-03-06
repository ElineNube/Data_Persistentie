package Inleveropdrachten.Les3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class OVChipkaartOracleDaoImpl extends OracleBaseDAO implements OVChipkaartDao{
	
	public OVChipkaart findByKey(int kaartnummer) {
	try {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String query = "SELECT * FROM OV_Chipkaart WHERE kaartnummer = " + kaartnummer;
		ResultSet rs = stmt.executeQuery(query);
		OVChipkaart ovk = null;
		while(rs.next()) {
			ovk = new OVChipkaart(
					rs.getInt("KAARTNUMMER"),
					rs.getDate("GELDIGTOT"),
					rs.getInt("KLASSE"),
					rs.getDouble("SALDO"),
					rs.getInt("REIZIGERID")
        );
		}	
		return ovk;
	} catch (SQLException e1) {
		e1.printStackTrace();
		return null;
	}

	}
	
	public List<OVChipkaart> findByReiziger(int reizigerID) {
		try {
			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM OV_Chipkaart WHERE REIZIGERID = " + reizigerID;
			ResultSet rs = stmt.executeQuery(query);
			List<OVChipkaart> list = new ArrayList<>();
			OVChipkaart ovk = null;
			while(rs.next()) {
				ovk = new OVChipkaart(
						rs.getInt("KAARTNUMMER"),
						rs.getDate("GELDIGTOT"),
						rs.getInt("KLASSE"),
						rs.getDouble("SALDO"),
						rs.getInt("REIZIGERID")
	        );
			list.add(ovk);
			}	
			return list;
		} catch (SQLException e1) {
			e1.printStackTrace();
			return null;
		}

		}
	
	public OVChipkaart save(OVChipkaart ovkaart) {
        try {
            Connection conn = getConnection();
            String sql = "INSERT INTO OV_CHIPKAART(KAARTNUMMER, GELDIGTOT, KLASSE, SALDO, REIZIGERID) VALUES(?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, ovkaart.getKaartnummer());
            preparedStatement.setDate(2, ovkaart.getGeldigTot());
            preparedStatement.setInt(3, ovkaart.getKlasse());
            preparedStatement.setDouble(4, ovkaart.getSaldo());
            preparedStatement.setInt(5, ovkaart.getReizigerID());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return ovkaart;
        } catch (SQLException e){
            System.out.println(e);
            return null;
        }
    }
	
    public OVChipkaart update(OVChipkaart ovkaart) {
    	try {
    			Connection conn = getConnection();
    			 String sql = "Update OV_CHIPKAART "
    			 				+ "SET REIZIGERID = ?,"
    			 				+ "GELDIGTOT = ?,"
    			 				+ "SALDO = ?,"
    			 				+ "KLASSE = ?"
    			 				+ "WHERE KAARTNUMMER = ?";
    	            PreparedStatement preparedStatement = conn.prepareStatement(sql);
    	            preparedStatement.setInt(1, ovkaart.getReizigerID());
    	            preparedStatement.setDate(2, ovkaart.getGeldigTot());
    	            preparedStatement.setDouble(3, ovkaart.getSaldo());
    	            preparedStatement.setInt(4, ovkaart.getKlasse());
    	            preparedStatement.setInt(5, ovkaart.getKaartnummer());
    	            preparedStatement.executeUpdate();
    	            preparedStatement.close();
                return ovkaart;	
    	} catch(SQLException e) {
    		System.out.println(e.getMessage());
    		return null;
    	}      
    }
    
    public boolean delete(OVChipkaart ovkaart) {
    		try {
       		 Connection conn = getConnection();
        		String sql = "DELETE FROM OV_CHIPKAART WHERE KAARTNUMMER = " + ovkaart.getKaartnummer();
       	        Statement statement = conn.createStatement();
       	        statement.executeUpdate(sql);
       	        boolean result = true;
       	        return result;
       	} catch(SQLException e) {
       		System.out.println(e.getMessage());
       		return false;
       	}     
       }
    
    public List<OVChipkaart> findAll() {
        try{
            Connection conn = getConnection();
            String sql = "SELECT * FROM OV_CHIPKAART";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            List<OVChipkaart> list = new ArrayList<>();
            OVChipkaart ovkaart;
            while (rs.next()) {
                ovkaart = new OVChipkaart(
						rs.getInt("KAARTNUMMER"),
						rs.getDate("GELDIGTOT"),
						rs.getInt("KLASSE"),
						rs.getDouble("SALDO"),
						rs.getInt("REIZIGERID")
	        );
                list.add(ovkaart);
            }
            rs.close();
            statement.close();
            return list;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public void setProductByOVkaart(int id, OVChipkaart chipkaart, int pnummer, String status, Date lastUpdate) {
    	try {
    		 Connection conn = getConnection();
             String sql = "INSERT INTO OV_CHIPKAART_PRODUCT(OVPRODUCTID, KAARTNUMMER, PRODUCTNUMMER, REISPRODUCTSTATUS, LASTUPDATE) VALUES(?,?,?,?,?)";
             PreparedStatement preparedStatement = conn.prepareStatement(sql);
             preparedStatement.setInt(1, id);
             preparedStatement.setInt(2, chipkaart.getKaartnummer());
             preparedStatement.setInt(3, pnummer);
             preparedStatement.setString(4, status);
             preparedStatement.setDate(5, lastUpdate);
             preparedStatement.executeUpdate();
             preparedStatement.close();
      	} catch(SQLException e) {
      		System.out.println(e.getMessage());
      	}     
      }
    
}

