package cl.bflores.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.bflores.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	public List<Product> findByNameContaining(String name);	
	public List<Product> findByCategory(int category);
	public List<Product> findByCategoryAndNameContaining(int category, String name);
	
}
