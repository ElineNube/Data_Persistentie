package Les_2.inleveropdracht;

import java.sql.Date;
import java.text.ParseException;
import java.sql.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
    	
    	// Reizigers aanmaken: 
    	
         Reiziger reiziger1 = new Reiziger(7, "DP", "van den", "Bunt");
         Reiziger reiziger2 = new Reiziger(8, "C", "van", "Opdorp");
    	 Reiziger reiziger3 = new Reiziger(9, "F", "de", "Boer");
    	  
       
          ReizigerOracleDaolmpl reizigerOracleDao = new ReizigerOracleDaolmpl();
          
          // Reiziger opslaan:
          
//        System.out.println("- Opgeslagen reiziger:" + reizigerOracleDao.save(reiziger1).toString());
//        System.out.println("- Opgeslagen reiziger:" + reizigerOracleDao.save(reiziger2).toString());
//        System.out.println("- Opgeslagen reiziger:" + reizigerOracleDao.save(reiziger3).toString());

          
          //Alle reizigers vinden
          System.out.println(reizigerOracleDao.findAll());
          
          //Reizigers vinden op geboortedatum
          System.out.println(reizigerOracleDao.findByGBdatum("17-09-02"));
          
          //Gegevens reiziger wijzigen en opslaan
          reiziger3.setVoorletters("ED");
          reiziger3.setAchternaam("Nube");
          System.out.println("- Reiziger is geupdate: " + reizigerOracleDao.update(reiziger3).toString());
          
          //Delete reiziger
          System.out.println("- Reiziger is verwijderd: " + reizigerOracleDao.delete(reiziger2));
          
          //OVChipkaart
          
          OVChipkaartOracleDaoImpl ovchipkaartOracleDao = new OVChipkaartOracleDaoImpl();
          
          System.out.println("- Zoek op OVkaart nummer: 35283\n " + ovchipkaartOracleDao.findByKey(35283));
          System.out.println("- Zoek op ReizigerID: 5 ->\n " + ovchipkaartOracleDao.findByReiziger(5));
          
          @SuppressWarnings("deprecation")
          OVChipkaart ov1 = new OVChipkaart(11111, new Date(1020, 1, 23), 2, 10.5, 5);
//          System.out.println("- Opgeslagen OVKaart:" + ovchipkaartOracleDao.save(ov1).toString());
          
        //Gegevens OVkaart wijzigen en opslaan
          ov1.setSaldo(30);
          ov1.setKlasse(1);
          System.out.println("- OV is geupdate: " + ovchipkaartOracleDao.update(ov1).toString());
          
        //Delete reiziger
          System.out.println("- OVKaart is verwijderd: " + ovchipkaartOracleDao.delete(ov1));
    }
}