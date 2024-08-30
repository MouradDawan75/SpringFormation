package fr.dawan.demomvc.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Transient;

@Entity
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = true)
	private String email;
	private String password;
	private boolean admin;
	
	/*
	 * BLOB: Binary Large Object: image, son et vidéo
	 * CLOB: Character Large Object : contenu d'un livre par exemple
	 */
	
	@Lob //large object
	@Column(name = "photo", columnDefinition = "MEDIUMBLOB")
	private byte[] photo;
	
	@Transient //attributs ignoré lors du mapping avec la BD -> pas de colonne en BD pour cet attribut
	private String imageBase64; //attribut pour afficher l'image dans une page web
	
	

	public String getImageBase64() {
		return imageBase64;
	}

	public void setImageBase64(String imageBase64) {
		this.imageBase64 = imageBase64;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public Utilisateur(long id, String email, String password, boolean admin, byte[] photo) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.admin = admin;
		this.photo = photo;
	}

	public Utilisateur() {
		super();
	}

	public Utilisateur(String email, String password, boolean admin, byte[] photo) {
		super();
		this.email = email;
		this.password = password;
		this.admin = admin;
		this.photo = photo;
	}
	
	
	

}
