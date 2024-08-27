package fr.dawan.backrestapi.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Version;

@Entity
public class Category extends BaseEntity{
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private long id;
//	
//	@Version
//	private int version;
	
	@Column(unique = true)
	private String name;
	
	//OneToMany avec Product
	/* Pour les suppressions, on doit gérer les clés de jointure
	 * La suppression d'une Category, implique la suppression de la clé de jointure dans la table Product
	 * 
	 * Chargement des relations:
	 * Lazy: chargement tardif - chargement à la demande
	 * Eager: chargement immédiat
	 * 
	 * Pour le many: JPA utilise le mode Lazy -> le chargement d'une Category -> n'indique pas la liste des produits associés
	 * Pour récupérer la liste des produits associés: on doit faire une demande explicite -> appeler le getter (getProducts)
	 */
	
	//-> modification du mode Lazy - déconseillé dans la pratique
	//@OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER) 
	@OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private Set<Product> products;

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
