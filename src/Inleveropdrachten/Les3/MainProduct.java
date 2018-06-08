package Inleveropdrachten.Les3;

import java.text.ParseException;

public class MainProduct {
	
	 public static void main(String[] args) throws ParseException {
	          
	          ProductOracleDaoImpl productOracleDao = new ProductOracleDaoImpl();
	          
	          System.out.println("- Zoek op productnummer: 3\n " + productOracleDao.findBykey(3));
	          System.out.println("- Zoek op productnummer: 6\n " +  productOracleDao.findBykey(6));
	          
	          Product p1 = new Product(8, "Studentweekend", "Studenten die op kamers wonen reizen in het weekend gratis", 0);
	          System.out.println("- Opgeslagen product:" + productOracleDao.save(p1).toString());
	          
	          p1.setPrijs(5);
	          
	          System.out.println(productOracleDao.findAll());
	          
	          System.out.println("- Product is verwijderd: " + productOracleDao.delete(p1));
	          
	          System.out.println(productOracleDao.findAll());
	 }

}
