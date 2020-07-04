package org.sid.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("client")
public class Client extends Personne{

	public Client() {
		super();
		
	}

	public Client(String nom, String prenom, String telephone, String email, String adresse, String ville,String typePersonne) {
		super(nom, prenom, telephone, email, adresse, ville,typePersonne);
		
	}
	

}
