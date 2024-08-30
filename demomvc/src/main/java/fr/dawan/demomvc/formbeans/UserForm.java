package fr.dawan.demomvc.formbeans;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class UserForm {
	
	
	private long id;
	
	@NotEmpty(message = "Champs obligatoire")
	@Email(message = "Email invalide")
	private String email;
	
	@NotEmpty(message = "Champs obligatoire")
	private String password;

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

	public UserForm(long id, @NotEmpty(message = "Champs obligatoire") @Email(message = "Email invalide") String email,
			@NotEmpty(message = "Champs obligatoire") String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}

	public UserForm(@NotEmpty(message = "Champs obligatoire") @Email(message = "Email invalide") String email,
			@NotEmpty(message = "Champs obligatoire") String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public UserForm() {
		super();
	}
	
	
	
	

}
