package fr.dawan.backrestapi.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;

//nom du package de JPA
//depuis la version 10: jakarta.persistence  avant la version 10 javax.persistse.api

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.Version;

@Entity
public class Product extends BaseEntity{
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private long id;
//	
//	//Gestion des accès conccurrentiels à des ressources partagées
//	@Version
//	private int version;
	
	@Column(unique = true, nullable = false, length = 512)
	private String description;
	
	@Column(name = "priceht", precision = 2)
	private double price;
	
	//@Lob // large object
	//private byte[] imageByte; //image stockées en binaire dans la table
	private String imagePath; //la table contient uniquement le chemin de l'image
	
	public enum ProductState{
		NEUF,EXCELLENT,MAUVAIS
	}
	
	
	//@Enumerated(EnumType.ORDINAL) c'est l'index de l'élément dans l'enum qui 
	@Enumerated(EnumType.STRING)
	private ProductState state;
	
	@Column(columnDefinition = "text") //champs de saisie multi-lignes
	private String comment;
	
	@ElementCollection // 1 table product_ingredients (PK/FK: product_id)
	private Set<String> ingredients;
	
	@ElementCollection
	@CollectionTable(name = "t_prices_promo")
	@MapKeyColumn(name = "promotion")
	@Column(name = "price")
	private Map<String, Double> pricesByPromotion;
	
	//OneToMany avec Category
	/*
	 * Chargement des relations:
	 * 1 seule Category: par défaut JPA utilise le mode EAGER (immédiat)
	 * 
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	//ManyToMany avec Supplier
	/*
	 * mappedBy: permet de choisir la classe principale et de générer qu'1 seule table de jointure
	 */
	@ManyToMany(cascade = CascadeType.REMOVE, mappedBy = "products")
	private Set<Supplier> suppliers;
	
	

	public Product() {
		//Initialiser tous les attributs de type collection
		ingredients = new HashSet();
		pricesByPromotion = new HashMap();
		suppliers = new HashSet();
	}

//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	public int getVersion() {
//		return version;
//	}
//
//	public void setVersion(int version) {
//		this.version = version;
//	}

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

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public ProductState getState() {
		return state;
	}

	public void setState(ProductState state) {
		this.state = state;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Set<String> getIngredients() {
//		if(ingredients == null) {
//			ingredients = new HashSet();
//		}
		return ingredients;
	}

	public void setIngredients(Set<String> ingredients) {
		this.ingredients = ingredients;
	}

	public Map<String, Double> getPricesByPromotion() {
		return pricesByPromotion;
	}

	public void setPricesByPromotion(Map<String, Double> pricesByPromotion) {
		this.pricesByPromotion = pricesByPromotion;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(Set<Supplier> suppliers) {
		this.suppliers = suppliers;
	}
	
	
	

}
