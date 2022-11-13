package cl.bflores.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.bflores.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	public List<Category> findAllByOrderByName();

}
