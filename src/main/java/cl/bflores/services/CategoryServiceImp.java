package cl.bflores.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.bflores.model.Category;
import cl.bflores.repository.CategoryRepository;

@Service
public class CategoryServiceImp implements CategoryService {

	//inyeccion de dependencias
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Category> findAll() {		
		return categoryRepository.findAllByOrderByName();
	}

}
