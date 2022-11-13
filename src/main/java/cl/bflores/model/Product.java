package cl.bflores.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "product")
public class Product {
	
	//atributos
	@Id
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "url_image")
	private String url_image;
	@Column(name = "price")
	private float price;
	@Column(name = "discount")
	private int discount;
	@Column(name = "category")
	private int category;	

}
