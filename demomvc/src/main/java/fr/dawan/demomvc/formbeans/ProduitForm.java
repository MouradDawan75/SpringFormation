package fr.dawan.demomvc.formbeans;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public class ProduitForm {
	

	private long id;
	
	@NotEmpty(message = "Ce champs est obligatoire")
	private String description;
	
	@DecimalMin(value = "10", message = "Prix min est 10")
	@DecimalMax(value = "1000", message = "Prix max est 1000")
	private double price;
	
	@Min(1)
	@Max(100)
	private int quantite;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public ProduitForm(long id, String description, double price, int quantite) {
		super();
		this.id = id;
		this.description = description;
		this.price = price;
		this.quantite = quantite;
	}
	public ProduitForm() {
		super();
	}
	
	public ProduitForm(String description, double price, int quantite) {
		super();
		this.description = description;
		this.price = price;
		this.quantite = quantite;
	}
	
	
}
