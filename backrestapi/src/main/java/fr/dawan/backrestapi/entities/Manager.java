package fr.dawan.backrestapi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/*
 * N'est pas une Entity (pas de table Manager - pas d'id)
 * @Embeddable: demande à JPA d'ajouter tous les attributs de cette classe dans la table Player
 */
@Embeddable
public class Manager{
	
	@Column(name = "manager_name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
