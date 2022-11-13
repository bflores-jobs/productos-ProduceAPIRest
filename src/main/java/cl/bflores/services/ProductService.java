package cl.bflores.services;

import java.util.List;
import java.util.Optional;

import cl.bflores.model.Product;

public interface ProductService {
	
	public List<Product> findAll();
	public Optional<Product> findById(int id);
	public List<Product> findByName(String name);
	public List<Product> findByCategory(int category);
	public List<Product> findByCategoryAndName(int category, String name);

}
