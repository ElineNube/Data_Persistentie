package Les_3.inleveropdracht;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class ProductOracleDaoImpl extends OracleBaseDAO implements ProductDao{
	
	
	public Product save(Product product) {
        try {
            Connection conn = getConnection();
            String sql = "INSERT INTO PRODUCT(productnummer, productnaam, beschrijving, prijs) VALUES(?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, product.getProductNummer());
            preparedStatement.setString(2, product.getProductNaam());
            preparedStatement.setString(3, product.getbeschrijving());
            preparedStatement.setDouble(4, product.getPrijs());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return product;
        } catch (SQLException e){
            System.out.println(e);
            return null;
        }
    }
	
	 public Product update(Product product) {
	    	try {
	    			Connection conn = getConnection();
	    			 String sql = "Update OV_CHIPKAART "
	    			 				+ "SET productnaam = ?,"
	    			 				+ "beschrijving = ?,"
	    			 				+ "prijs = ?,"
	    			 				+ "WHERE productnummer = ?";
	    	            PreparedStatement preparedStatement = conn.prepareStatement(sql);
	    	            preparedStatement.setString(1, product.getProductNaam());
	    	            preparedStatement.setString(2, product.getbeschrijving());
	    	            preparedStatement.setDouble(3, product.getPrijs());
	    	            preparedStatement.setInt(4, product.getProductNummer());
	    	            preparedStatement.executeUpdate();
	    	            preparedStatement.close();
	                return product;	
	    	} catch(SQLException e) {
	    		System.out.println(e.getMessage());
	    		return null;
	    	}      
	    }
	 
	    public boolean delete(Product product) {
    		try {
       		 Connection conn = getConnection();
        		String sql = "DELETE FROM product WHERE productnummer = " + product.getProductNummer();
       	        Statement statement = conn.createStatement();
       	        statement.executeUpdate(sql);
       	        boolean result = true;
       	        return result;
       	} catch(SQLException e) {
       		System.out.println(e.getMessage());
       		return false;
       	}     
       }
	    
	    public List<Product> findAll() {
	        try{
	            Connection conn = getConnection();
	            String sql = "SELECT * FROM product";
	            Statement statement = conn.createStatement();
	            ResultSet rs = statement.executeQuery(sql);
	            List<Product> list = new ArrayList<>();
	            Product product;
	            while (rs.next()) {
	            	product = new Product(
							rs.getInt("productnummer"),
							rs.getString("productnaam"),
							rs.getString("beschrijving"),
							rs.getDouble("prijs")
		        );
	                list.add(product);
	            }
	            rs.close();
	            statement.close();
	            return list;
	        } catch (SQLException e){
	            System.out.println(e.getMessage());
	            return null;
	        }
	    }

		public Product findBykey(int productNummer) {
			try {
				Connection conn = getConnection();
				Statement stmt = conn.createStatement();
				String query = "SELECT * FROM product WHERE productnummer = " + productNummer;
				ResultSet rs = stmt.executeQuery(query);
				Product product = null;
				while(rs.next()) {
					product = new Product(
							rs.getInt("productnummer"),
							rs.getString("productnaam"),
							rs.getString("beschrijving"),
							rs.getDouble("prijs")
		        );
				}	
				return product;
			} catch (SQLException e1) {
				e1.printStackTrace();
				return null;
			}
		}

}
