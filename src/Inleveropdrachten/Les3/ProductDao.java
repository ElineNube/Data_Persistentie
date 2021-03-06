package Inleveropdrachten.Les3;

import java.util.List;

public interface ProductDao {
	
	public Product findById(int productNummer);
	
	public Product save(Product product);
	
	public List<Product> findAll();
	
	public boolean delete(Product product);

}
