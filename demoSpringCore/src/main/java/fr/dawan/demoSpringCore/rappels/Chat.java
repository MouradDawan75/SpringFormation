package fr.dawan.demoSpringCore.rappels;

public class Chat extends Animal{
	
	private String couleur;

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
	public void dormir() {
		System.out.println("dormir...........");
	}

	@Override
	public void emettreSon() {
		System.out.println("Miauller........");
	}
	
	

}
