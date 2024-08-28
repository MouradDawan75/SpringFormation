package fr.dawan.demoSpringCore.rappels;

public class Animal {
	/*
	 * Encapsulation:
	 * Les attributs d'une classe doivent être privés.
	 * L'accès aux attributs passe forcément par les accésseurs (get/set)
	 * Les getters/setters permettent de mettre en place des contrôles (de gérer les contraintes définies par le client)
	 * 
	 */
	
	private String nom;
	private int age;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) throws Exception {
		if(age >= 1 && age <= 10)
			this.age = age;
		else
			throw new Exception("Age doit être compris entre 1 et 10");
	}
	//Méthode d'instance qui concerne une instance particulière
	
	public void emettreSon() {
		System.out.println("Son de l'animal......");
	}
	
	private void test() {
		
	}
	
	
	

}
