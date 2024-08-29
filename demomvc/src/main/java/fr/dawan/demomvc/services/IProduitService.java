package fr.dawan.demomvc.services;

import java.util.List;

import fr.dawan.demomvc.entities.Produit;

public interface IProduitService {

	void create(Produit p) throws Exception;

	void update(Produit p) throws Exception;

	void deleteById(long id) throws Exception;

	List<Produit> getAll() throws Exception;

	Produit getById(long id) throws Exception;

	List<Produit> findByDescription(String key) throws Exception;

}