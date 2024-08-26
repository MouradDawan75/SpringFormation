package fr.dawan.demoSpringCore.rappels;

public class Produit {
	
	/*
	 * Les types numériques par défaut = 0
	 * Type boolean par défaut = false
	 * Type complèxe: null
	 */
	
	private int id;
	private String nom;
	private boolean dispo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public boolean isDispo() {
		return dispo;
	}
	public void setDispo(boolean dispo) {
		this.dispo = dispo;
	}
	public Produit(int id, String nom, boolean dispo) {
		super();
		this.id = id;
		this.nom = nom;
		this.dispo = dispo;
	}
	public Produit() {
		super();
	}
	
	

}
