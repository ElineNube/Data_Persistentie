package Les_2.inleveropdracht;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
    	
    	// Reizigers aanmaken: 
    	
         Reiziger reiziger1 = new Reiziger(7, "DP", "van den", "Bunt");
         Reiziger reiziger2 = new Reiziger(8, "C", "van", "Opdorp");
    	 Reiziger reiziger3 = new Reiziger(9, "F", "de", "Boer");
    	  
       
          ReizigerOracleDaolmpl reizigerOracleDao = new ReizigerOracleDaolmpl();
          
          // Reiziger opslaan:
          
          System.out.println("- Opgeslagen reiziger:" + reizigerOracleDao.save(reiziger1).toString());
          System.out.println("- Opgeslagen reiziger:" + reizigerOracleDao.save(reiziger2).toString());
          System.out.println("- Opgeslagen reiziger:" + reizigerOracleDao.save(reiziger3).toString());

          
          //Alle reizigers vinden
          System.out.println(reizigerOracleDao.findAll());
          
          //Reizigers vinden op geboortedatum
          System.out.println(reizigerOracleDao.findByGBdatum("17-09-02"));
          
          //Gegevens reiziger wijzigen en opslaan
          reiziger3.setVoorletters("ED");
          reiziger3.setAchternaam("Nube");
          System.out.println("- Reiziger is geupdate: " + reizigerOracleDao.update(reiziger3).toString());
          
          //Delete reiziger
          System.out.println("- Reiziger is verwijderd: " + reizigerOracleDao.delete(reiziger1));
          System.out.println("- Reiziger is verwijderd: " + reizigerOracleDao.delete(reiziger2));
          System.out.println("- Reiziger is verwijderd: " + reizigerOracleDao.delete(reiziger3));
          
          //Alle reizigers vinden
          System.out.println(reizigerOracleDao.findAll());
          
    }
}