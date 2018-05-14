package Les_2.inleveropdracht;

import java.util.List;

public interface OVChipkaartDao {
	
	public OVChipkaart save(ReiziOVger reiziger);

    public List<Reiziger> findAll();

    public List<Reiziger> findByGBdatum(String geboortedatum);

    public Reiziger update(Reiziger reiziger);

    public boolean delete(Reiziger reiziger);

}
