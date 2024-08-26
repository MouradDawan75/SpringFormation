package fr.dawan.demoSpringCore.entities;

import org.springframework.stereotype.Component;

@Component
public class Moteur {
	
	public void demarrer() {
		System.out.println("Moteur démarré..........");
	}

}
