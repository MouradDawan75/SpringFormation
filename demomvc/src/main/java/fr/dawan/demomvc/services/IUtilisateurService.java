package fr.dawan.demomvc.services;

import java.util.List;

import fr.dawan.demomvc.entities.Utilisateur;

public interface IUtilisateurService {

	void create(Utilisateur u) throws Exception;

	void update(Utilisateur u) throws Exception;

	void deleteById(long id) throws Exception;

	List<Utilisateur> getAll() throws Exception;

	Utilisateur findByEmail(String email) throws Exception;

	Utilisateur findById(long id) throws Exception;

}