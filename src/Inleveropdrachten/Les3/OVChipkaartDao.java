package Inleveropdrachten.Les3;

import java.util.List;

public interface OVChipkaartDao {

    public OVChipkaart findByKey(int kaartnummer);
    
    public List<OVChipkaart> findByReiziger(int ReizigerID);
    
    public OVChipkaart save(OVChipkaart ovkaart);
    
    public List<OVChipkaart> findAll();
    
    public boolean delete(OVChipkaart ovkaart);
    

}
