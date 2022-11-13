package cl.bflores.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.bflores.model.Category;
import cl.bflores.services.CategoryService;

@RestController
@RequestMapping("/api/v1")
public class CategoryRestController {
	
	//inyeccion de dependencias
	@Autowired
	private CategoryService categoryService;
	
	//getAllCategory
	@GetMapping("/categorias")
	public ResponseEntity<List<Category>> getAllCategory(){		
		
		try {
			List<Category> categorias = new ArrayList<Category>();
			
			categorias = categoryService.findAll();
			
			if(categorias.isEmpty()) {
				return new ResponseEntity<>(categorias, HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(categorias, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	

}
