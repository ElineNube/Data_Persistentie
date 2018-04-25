package Inleveropdrachten.Les_1;

import Inleveropdrachten.Les_1.Reiziger;

import java.sql.Date;
import java.util.List;

public interface ReizigerDao {
    public List<Reiziger> findAll();

    public List<Reiziger> findByGBdatum(Date GBdatum);

    public Reiziger save(Reiziger reiziger);

    public Reiziger update(Reiziger reiziger);

    public boolean delete(Reiziger reiziger);
}
