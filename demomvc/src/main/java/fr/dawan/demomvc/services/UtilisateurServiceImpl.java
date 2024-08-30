package fr.dawan.demomvc.services;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.dawan.demomvc.entities.Utilisateur;
import fr.dawan.demomvc.repositories.UtilisateurRepository;

@Service
public class UtilisateurServiceImpl implements IUtilisateurService {

	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public void create(Utilisateur u) throws Exception{
		//Crypter le password en BD
		u.setPassword(encoder.encode(u.getPassword()));
		utilisateurRepository.saveAndFlush(u);
	}
	
	@Override
	public void update(Utilisateur u) throws Exception{
		//Si password modifié côté Front -> on doit le crypter
		
		Utilisateur userDb = utilisateurRepository.findById(u.getId()).get(); 
		//userDb contient un password crypté
		
		if(!userDb.getPassword().equals(u.getPassword())) {
			//mot de passe modifié côté Front
			u.setPassword(encoder.encode(u.getPassword()));
		}
		
		
		utilisateurRepository.saveAndFlush(u);
	}
	
	@Override
	public void deleteById(long id) throws Exception{
		utilisateurRepository.deleteById(id);
	}
	
	@Override
	public List<Utilisateur> getAll() throws Exception{
		
		List<Utilisateur> lst = utilisateurRepository.findAll();
	
		//encoder les photos en chaine codée en 64 bits
		
		for(Utilisateur u : lst) {
			
			if(u.getPhoto() != null) {
				byte[] encodeBase64 = Base64.getEncoder().encode(u.getPhoto());
				String chaine64 = new String(encodeBase64,"UTF-8");
				u.setImageBase64(chaine64);
			}
			
		}
		
		
		return lst;
	}
	
	@Override
	public Utilisateur findByEmail(String email) throws Exception{
		return utilisateurRepository.findByEmail(email);
	}
	
	@Override
	public Utilisateur findById(long id) throws Exception{
		 Optional<Utilisateur> optional = utilisateurRepository.findById(id);
		 if(optional.isPresent()) {
			 return optional.get();
		 }
		 return null;
	}
	
}
