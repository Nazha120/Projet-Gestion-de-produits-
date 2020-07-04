package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_PERSONNE")
public class Personne implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	private String nom;
	private String prenom;
	private String telephone;
	private String email;
	private String adresse;
	private String ville;
	@Column(name="TYPE_PERSONNE", nullable=false, updatable=false, insertable=false)
	private String typePersonne;
	
	public Personne() {
		super();
	}
	public Personne(String nom, String prenom, String telephone, String email, String adresse, String ville, String typePersonne ) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.email = email;
		this.adresse = adresse;
		this.ville = ville;
		this.typePersonne = typePersonne;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTypePersonne() {
		return typePersonne;
	}

	public void setTypePersonne(String typePersonne) {
		this.typePersonne = typePersonne;
	}

}
