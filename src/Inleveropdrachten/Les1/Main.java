package Inleveropdrachten.Les1;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;

public class Main {
  public static void main(String[] args) throws ParseException {
	  
	  	//Datums formatteren voor constructor
        Date GBEline = new Date(97,7,2);
        Date GBDennis = new Date(96,0,16);
        Date GBPatricia = new Date(64,2,2);


        //Twee reizigers toevoegen
        Reiziger r1 = new Reiziger("Eline", GBEline);
        Reiziger r2 = new Reiziger("Dennis", GBDennis);

        ReizigerOracleDaolmpl i1 = new ReizigerOracleDaolmpl();

        //Reizigers opslaan in database
        i1.save(r1);
        i1.save(r2);
        System.out.println("De reizigers uit de database: \n" + i1.findAll());

        //Reizigers verwijderen
        i1.delete(r2);
        System.out.println("De reizigers in database na het verwijderen van r2: \n" + i1.findAll());

        //Derde reiziger toevoegen
        Reiziger r3 = new Reiziger("Patricia", GBPatricia);
        i1.save(r3);
        System.out.println("De reizigers in database na het toevoegen van r3:\n " + i1.findAll());

        //Reizigers met geboortedatum vinden
        List<Reiziger> vindenOpDatum = i1.findByGBdatum("02-08-1997");
        System.out.println("Reizigers met geboortedatum 02-08-1997:\n" + vindenOpDatum);
        
        //Reiziger updaten
        r3.setNaam("Frank");
        i1.update(r3);
        System.out.println("De reizigers uit de database: \n" + i1.findAll());
        


    }
}