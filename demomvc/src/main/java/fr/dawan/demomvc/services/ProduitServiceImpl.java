package fr.dawan.demomvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.demomvc.entities.Produit;
import fr.dawan.demomvc.repositories.ProduitRepository;

@Service
public class ProduitServiceImpl implements IProduitService {
	
	@Autowired
	private ProduitRepository produitRepository;
	
	@Override
	public void create(Produit p) throws Exception{
		produitRepository.saveAndFlush(p);
	}
	
	@Override
	public void update(Produit p) throws Exception{
		produitRepository.saveAndFlush(p);
	}
	
	@Override
	public void deleteById(long id) throws Exception{
		produitRepository.deleteById(id);
	}
	
	@Override
	public List<Produit> getAll() throws Exception{
		return produitRepository.findAll();
	}
	
	@Override
	public Produit getById(long id) throws Exception{
		Optional<Produit> optional = produitRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	@Override
	public List<Produit> findByDescription(String key) throws Exception{ 
		//return produitRepository.findByKey("%"+key+"%"); si utilisation de la commande JPQL: les % sont nécessaire
		
		// pour la finder méthoder : les % ne sont pas nécessaire car générés par Spring Data
		
		return produitRepository.findByDescriptionContaining(key); 
	}
	

}
