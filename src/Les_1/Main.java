package Les_1;

import java.sql.Date;
import java.util.List;

public class Main {
  public static void main(String[] args) {
        Date GBEline = new Date(97,7,2);
        Date GBDennis = new Date(96,0,16);
        Date GBPatricia = new Date(64,2,2);



        Reiziger r1 = new Reiziger("Eline", GBEline);
        Reiziger r2 = new Reiziger("Dennis", GBDennis);

        ReizigerOracleDaolmpl i1 = new ReizigerOracleDaolmpl();

      i1.save(r1);
        i1.save(r2);

        System.out.println(i1.findAll());

        i1.delete(r2);
        System.out.println(i1.findAll());

        Reiziger r3 = new Reiziger("Patricia", GBPatricia);
        i1.save(r3);

        System.out.println(i1.findAll());

       List<Reiziger> vindenOpDatum = i1.findByGBdatum((GBDennis));
      System.out.println(vindenOpDatum);

        //Alle reizigers tonen
        System.out.println(i1.findAll());

    }
}