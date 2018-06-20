package Inleveropdrachten.Les3;

public class Main {
	
	public static void main(String[] args) {
		
		ProductDao pDAO = new ProductOracleDaoImpl();
        OVChipkaart_ProductDao ov_pDAO = new OVChipkaart_ProductDaoImpl();

        // Selecteer een product uit de producttabel met id 1
        System.out.println("Product met id 1");
        System.out.println("Productnaam: " + pDAO.findById(1).getProductNaam());
        System.out.println("Productbeschrijving: " + pDAO.findById(1).getbeschrijving());
        System.out.println("Productprijs: " + pDAO.findById(1).getPrijs());

        // Selecteer een relatie uit de koppeltabel met relatie id 1
        System.out.println("\nRelatie uit de koppeltabel met id 1");
        System.out.println("Kaartnummer: " + ov_pDAO.findById(1).getOVChipkaart().getKaartnummer());
        System.out.println("Productnummer: " + ov_pDAO.findById(1).getProduct().getProductNummer());
        System.out.println("Reisproduct status: " + ov_pDAO.findById(1).getReisproductStatus());
        System.out.println("Laatste update: " + ov_pDAO.findById(1).getLastUpdate());

        // Selecteer de relatie van kaartnummer 35283
        System.out.println("\nSelecteer de relatie van kaartnummer 35283");
        System.out.println("KoppelID: " + ov_pDAO.findByIdInOVChipkaart(35283).getOvproductID());
        System.out.println("Reisproduct status: " + ov_pDAO.findByIdInOVChipkaart(35283).getReisproductStatus());
        System.out.println("Kaartnummer: " + ov_pDAO.findByIdInOVChipkaart(35283).getOVChipkaart().getKaartnummer());
        System.out.println("saldo: " + ov_pDAO.findByIdInOVChipkaart(35283).getOVChipkaart().getSaldo());

        // Vind alle informatie over kaartnummer 1111111111
        System.out.println("\nVind alle informatie over kaartnummer 1111111111");
        for (OVChipkaart_Product ov_p : ov_pDAO.findByIdInBothTables(35283)) {
            System.out.println("ov_productID: " + ov_p.getOvproductID());
            System.out.println("Reisproduct status: " + ov_p.getReisproductStatus());
            System.out.println("Kaartnummer: " + ov_p.getOVChipkaart().getKaartnummer());
            System.out.println("saldo: " + ov_p.getOVChipkaart().getSaldo());
            System.out.println("productNaam: " + ov_p.getProduct().getProductNaam() + "\n");
        }
    }
}
