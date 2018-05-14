package Inleveropdrachten.Les_1;

import lesopdracht.Reiziger;

import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class ReizigerOracleDaolmpl implements ReizigerDao {

    private ArrayList<Reiziger> deReizigers = new ArrayList<>();

    public List<Reiziger> findAll() {
        return this.deReizigers;
    }

    public List<Reiziger> findByGBdatum(Date GBdatum) {
        List<Reiziger> resultaat = new ArrayList<>();
        for (Reiziger r : this.deReizigers) {
            if (r.getGBdatum()== GBdatum) {
                resultaat.add(r);
            }
        }
        return resultaat;
    }

    public Reiziger save(Reiziger reiziger) {
        if (!deReizigers.contains(reiziger)){
            deReizigers.add(reiziger);
        }
        return reiziger;
    }

    public Reiziger update(Reiziger reiziger) {
        return reiziger;
    }

    public boolean delete(Reiziger reiziger) {
        boolean resultaat = false;

        if (deReizigers.contains(reiziger)) {
            deReizigers.remove(reiziger);
            resultaat = true;
        }
        return resultaat;
    }
}
