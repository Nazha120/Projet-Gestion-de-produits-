package org.sid.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("fournisseur")
public class Fournisseur extends Personne {

	public Fournisseur() {
		super();
		
	}

	public Fournisseur(String nom, String prenom, String telephone, String email, String adresse, String ville,String typePersonne) {
		super(nom, prenom, telephone, email, adresse, ville,typePersonne);
		
		
	}
	

}
