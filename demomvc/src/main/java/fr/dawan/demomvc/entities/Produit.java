package fr.dawan.demomvc.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = true)
	private String description;
	private double price;
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
	public Produit(long id, String description, double price, int quantite) {
		super();
		this.id = id;
		this.description = description;
		this.price = price;
		this.quantite = quantite;
	}
	public Produit() {
		super();
	}
	
	public Produit(String description, double price, int quantite) {
		super();
		this.description = description;
		this.price = price;
		this.quantite = quantite;
	}
	
	

}
