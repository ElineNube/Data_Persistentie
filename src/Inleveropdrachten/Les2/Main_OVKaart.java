package Inleveropdrachten.Les2;

import java.sql.Date;
import java.text.ParseException;

public class Main_OVKaart {
	
	    public static void main(String[] args) throws ParseException {
	    	
	    	//OVChipkaart
	          
	          OVChipkaartOracleDaoImpl ovchipkaartOracleDao = new OVChipkaartOracleDaoImpl();
	          
	          System.out.println("- Zoek op OVkaart nummer: 35283\n " + ovchipkaartOracleDao.findByKey(35283));
	          System.out.println("- Zoek op ReizigerID: 5 ->\n " + ovchipkaartOracleDao.findByReiziger(5));
	          
	          @SuppressWarnings("deprecation")
	          OVChipkaart ov1 = new OVChipkaart(11111, new Date(1020, 1, 23), 2, 10.5, 5);
	          System.out.println("- Opgeslagen OVKaart:" + ovchipkaartOracleDao.save(ov1).toString());
	          
	        //Gegevens OVkaart wijzigen en opslaan
	          ov1.setSaldo(30);
	          ov1.setKlasse(1);
	          System.out.println("- OV is geupdate: " + ovchipkaartOracleDao.update(ov1).toString());
	          
		      //Alle OVKaarten vinden
	          System.out.println(ovchipkaartOracleDao.findAll());
	          
	        //Delete reiziger
	          System.out.println("- OVKaart is verwijderd: " + ovchipkaartOracleDao.delete(ov1));
	          
		        //Alle OVKaarten vinden
	          System.out.println(ovchipkaartOracleDao.findAll());
	          
	          
	    	
	    }

}
