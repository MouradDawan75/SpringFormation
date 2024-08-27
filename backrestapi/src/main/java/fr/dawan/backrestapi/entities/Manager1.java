package fr.dawan.backrestapi.entities;

import jakarta.persistence.Entity;

@Entity
public class Manager1 extends BaseEntity{
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
