package fr.dawan.demomvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.dawan.demomvc.entities.Utilisateur;

//@Repository -> non nécessaire car utilisée dans JpaRepository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
	
	Utilisateur findByEmail(String email);

}
