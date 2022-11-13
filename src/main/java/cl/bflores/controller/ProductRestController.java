package cl.bflores.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.bflores.model.Product;
import cl.bflores.services.ProductService;

@RestController
@RequestMapping("/api/v1")
public class ProductRestController {
	
	//inyeccion de dependencias
	@Autowired
	private ProductService productService;
	
	//getAllProduct
	@GetMapping("/productos")
	public ResponseEntity<List<Product>> getAllProduct(@RequestParam(required = false) Integer category, @RequestParam(required = false) String name){
		
		try {
			List<Product> productos = new ArrayList<Product>();
			
			if(name == null && category == null) {
				productos = productService.findAll();
			}else if(name != null && category != null) {
				productos = productService.findByCategoryAndName(category, name);
			}else if(name != null) {
					productos = productService.findByName(name);
			}else {
					productos = productService.findByCategory(category);
			}			
							
			if(productos.isEmpty()) {
				return new ResponseEntity<>(productos, HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(productos, HttpStatus.OK);			
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//getProductById
	@GetMapping("/productos/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") int id){
		
		try {
			Optional<Product> productoEncontrado = productService.findById(id);
			if (productoEncontrado.isPresent()) {
				return new ResponseEntity<>(productoEncontrado.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	

}
