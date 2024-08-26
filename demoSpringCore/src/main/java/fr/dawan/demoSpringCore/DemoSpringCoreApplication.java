package fr.dawan.demoSpringCore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import fr.dawan.demoSpringCore.entities.Moteur;
import fr.dawan.demoSpringCore.entities.Voiture;

@SpringBootApplication
//@ComponentScan(basePackages = {"fr.dawan.entities"}) -> demande explicite d'inclure le package fr.dawan.entities dans scan 
                                                         // car ce n'est pas un sous package du package de base
public class DemoSpringCoreApplication {
	
	 static ConfigurableApplicationContext context;

	 //Méthode exécutée au démarrage de l'application
	public static void main(String[] args) {
		
//		Moteur m = new Moteur();
//		Voiture v = new Voiture();
//		v.setMoteur(m);
//		v.demarrer();
		
		//IOC: Inversion Of Control
		//Spring prend le contrôle sur:
		/*
		 * Instanciation des classes
		 * Gestion des dépendances
		 */
		
		 //Context: zone mémoire portant le nom de l'application et contenant tous les objets crées par Spring au démarrage
		// de l'application
		
		
		
		context = SpringApplication.run(DemoSpringCoreApplication.class, args);
		test();
		
		System.out.println("*********** Tous les beans:");
		allBeans();
	}
	
	public static void test() {
		
		//bean: désigne un objet crée par Spring
		
		Voiture v = context.getBean(Voiture.class);
		v.demarrer();
		
		Moteur m =context.getBean(Moteur.class);
		
	}
	
	public static void allBeans() {
		//Liste des objets instanciés par Spring au démarrage de l'application
		String[] beans = context.getBeanDefinitionNames();
		for(String b : beans) {
			System.out.println(b);
		}
	}

}
