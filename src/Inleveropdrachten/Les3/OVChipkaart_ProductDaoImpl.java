package Inleveropdrachten.Les3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OVChipkaart_ProductDaoImpl extends OracleBaseDAO implements OVChipkaart_ProductDao{
	
	public OVChipkaart_Product findById(int id) {
		OVChipkaart_Product ov_pr = new OVChipkaart_Product();
		
		try (Connection con = super.getConnection()) {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM ov_chipkaart_product WHERE ovproductid = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				OVChipkaart o = new OVChipkaart();
                Product p = new Product();
                
				ov_pr.setOvproductID(rs.getInt("ovproductid"));
				ov_pr.setReisproductStatus(rs.getString("reisproductstatus"));
				ov_pr.setLastUpdate(rs.getString("reisproductstatus"));
				o.setKaartnummer(rs.getInt("kaartnummer"));
				p.setProductNummer(rs.getInt("productnummer"));
				ov_pr.setOVChipkaart(o);
				ov_pr.setProduct(p);
			}
		
		} catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return ov_pr;
	}
	
	public OVChipkaart_Product findByIdInOVChipkaart(int id) {
        OVChipkaart_Product ov_p = new OVChipkaart_Product();
        try (Connection con = super.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(
                    "SELECT ov_c_p.ovproductid, ov_c_p.reisproductstatus, ov_c.kaartnummer, ov_c.saldo " +
                            "FROM ov_chipkaart_product ov_c_p, ov_chipkaart ov_c " +
                            "WHERE ov_c.kaartnummer = ov_c_p.kaartnummer AND ov_c.kaartnummer = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int ovproductID = rs.getInt("ovproductid");
                String reisproductStatus = rs.getString("reisproductstatus");
                int kaartNummer = rs.getInt("kaartnummer");
                double saldo = rs.getDouble("saldo");

                OVChipkaart o = new OVChipkaart();
                ov_p.setOvproductID(ovproductID);
                ov_p.setReisproductStatus(reisproductStatus);
                o.setKaartnummer(kaartNummer);
                o.setSaldo(saldo);
                ov_p.setOVChipkaart(o);
            }
//            con.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return ov_p;
    }
    public ArrayList<OVChipkaart_Product> findByIdInBothTables(int id) {
        ArrayList<OVChipkaart_Product> ov_pList = new ArrayList<OVChipkaart_Product>();
        try (Connection con = super.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("SELECT ov_c_p.ovproductid, ov_c_p.reisproductstatus, ov_c.kaartnummer, ov_c.saldo, p.productnaam " +
                    "FROM ov_chipkaart_product ov_c_p, ov_chipkaart ov_c, product p " +
                    "WHERE ov_c.kaartnummer = ov_c_p.kaartnummer AND ov_c_p.kaartnummer = ?");

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                OVChipkaart_Product ov_product = new OVChipkaart_Product();
                int ovproductID = rs.getInt("ovproductid");
                String reisproductStatus = rs.getString("reisproductstatus");
                int kaartNummer = rs.getInt("kaartnummer");
                double saldo = rs.getDouble("saldo");
                String productNaam = rs.getString("productnaam");

                OVChipkaart kaart = new OVChipkaart();
                Product p = new Product();
                ov_product.setOvproductID(ovproductID);
                ov_product.setReisproductStatus(reisproductStatus);
                kaart.setKaartnummer(kaartNummer);
                kaart.setSaldo(saldo);
                p.setProductNaam(productNaam);
                ov_product.setOVChipkaart(kaart);
                ov_product.setProduct(p);
                ov_pList.add(ov_product);
            }
            rs.close();
            stmt.close();

        } catch ( SQLException sqle) {
            sqle.printStackTrace();
        }

        return ov_pList;
    }
}

