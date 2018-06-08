package Inleveropdrachten.Les1;

import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ReizigerOracleDaolmpl implements ReizigerDao {

    private ArrayList<Reiziger> deReizigers = new ArrayList<>();

    public List<Reiziger> findAll() {
    	System.out.println("Methode findAll uitgevoerd");
        return this.deReizigers;
    }

    public List<Reiziger> findByGBdatum(String GBdatum) throws ParseException {
    	System.out.println("Methode findByGBdatum uitgevoerd");
    	SimpleDateFormat df1 = new SimpleDateFormat("dd-MM-yyyy");
    	java.util.Date date = df1.parse(GBdatum);
    	java.sql.Date gbd = new java.sql.Date(date.getTime());
    	
        List<Reiziger> resultaat = new ArrayList<>();
        
        for (Reiziger r : this.deReizigers) {
            if (r.getGBdatum().equals(gbd)) {
                resultaat.add(r);
            }
        }
        return resultaat;
    }

    public Reiziger save(Reiziger reiziger) {
    	System.out.println("Methode save uitgevoerd");
        if (!deReizigers.contains(reiziger)){
            deReizigers.add(reiziger);
        }
        return reiziger;
    }

    public Reiziger update(Reiziger reiziger) {
    	System.out.println("Methode update uitgevoerd");
    	if (reiziger == null)
			throw new IllegalArgumentException("Reiziger mag niet null zijn");

		for (Reiziger r : deReizigers) {
			if (r.equals(reiziger)) {
				r.setNaam(reiziger.getNaam());
				r.setGBdatum(reiziger.getGBdatum());
			}
		}
		return reiziger;
	}

    public boolean delete(Reiziger reiziger) {
    	System.out.println("Methode delete uitgevoerd");
        boolean resultaat = false;

        if (deReizigers.contains(reiziger)) {
            deReizigers.remove(reiziger);
            resultaat = true;
        }
        return resultaat;
    }
}
