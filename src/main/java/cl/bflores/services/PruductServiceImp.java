package cl.bflores.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.bflores.model.Product;
import cl.bflores.repository.ProductRepository;

@Service
public class PruductServiceImp implements ProductService {

	//inyeccion de dependencias
	@Autowired	
	private ProductRepository productRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Product> findAll() {		
		return productRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Product> findById(int id) {		
		return productRepository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Product> findByName(String name) {		
		return productRepository.findByNameContaining(name);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Product> findByCategory(int category) {		
		return productRepository.findByCategory(category);
	}

	@Override
	public List<Product> findByCategoryAndName(int category, String name) {
		return productRepository.findByCategoryAndNameContaining(category, name);
	}

}
