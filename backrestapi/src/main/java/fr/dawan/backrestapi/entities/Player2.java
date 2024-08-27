package fr.dawan.backrestapi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Player2 extends BaseEntity{
	
	private String name;
	
	//Player et Manager ne possèdent pas forcément le mm id contrairement à l'option 2 (Voir classe Player1) 
	@OneToOne
	@JoinColumn(unique = true)
	private Manager2 manager;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Manager2 getManager() {
		return manager;
	}

	public void setManager(Manager2 manager) {
		this.manager = manager;
	}
	
	

}
