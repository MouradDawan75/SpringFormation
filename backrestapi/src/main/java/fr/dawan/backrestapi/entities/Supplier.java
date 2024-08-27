package fr.dawan.backrestapi.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

@Entity
public class Supplier extends BaseEntity{
	
	private String name;
	
	//ManyToMany avec Product
	
	@ManyToMany(cascade = CascadeType.REMOVE)
	private Set<Product> products;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Product> getProducts() {
		if(products == null) {
			products = new HashSet();
		}
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	

}
