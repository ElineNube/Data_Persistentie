package Lesopdracht.Les2;

public class Main {
    public static void main(String[] args) {
        Reiziger reiziger1 = new Reiziger(7, "DP", "van den", "Bunt");
        Reiziger reiziger2 = new Reiziger(8, "C", "van", "Opdorp");
       
        ReizigerOracleDaolmpl reizigerOracleDao = new ReizigerOracleDaolmpl();
        System.out.println("#Saved reiziger:" + reizigerOracleDao.save(reiziger1).toString());
        System.out.println("#Saved reiziger:" + reizigerOracleDao.save(reiziger2).toString());
    }
}