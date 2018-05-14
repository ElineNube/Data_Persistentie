package Les_2.lesopdracht;

import java.sql.Date;
import java.util.List;

public interface ReizigerDao {
    public Reiziger save(Reiziger reiziger);

    public List<Reiziger> findAll();

    public List<Reiziger> findByGBdatum(Date geboortedatum);

    public Reiziger update(Reiziger reiziger);

    public boolean delete(Reiziger reiziger);
}
