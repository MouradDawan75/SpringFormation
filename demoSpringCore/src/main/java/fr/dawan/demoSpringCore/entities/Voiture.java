package fr.dawan.demoSpringCore.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //Annotation qui demande à Spring COre de créer un objet Voiture au démarrage de l'application
public class Voiture {
	
	@Autowired // Annotation qui demande à Spring Core d'injecter l'objet moteur dans l'objet voiture
	private Moteur moteur;
	
	


	public void demarrer() {
		moteur.demarrer();
	}

}
