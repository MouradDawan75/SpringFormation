package fr.dawan.backrestapi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
public class Player1 extends BaseEntity{
	
	private String name;
	
	@OneToOne @MapsId //Player et Manager possède le mm id qui est la clé de jointure
	private Manager1 manager;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Manager1 getManager() {
		return manager;
	}

	public void setManager(Manager1 manager) {
		this.manager = manager;
	}
	
	
	
	

}
