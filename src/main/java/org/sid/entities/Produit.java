package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Produit implements Serializable {
	@Id
	@GeneratedValue
	private long id;
	private String libelle;
	private int reference;
	private double prix;
	private int quantiteDisponible;
	private int quantiteCritique;
	
	public Produit() {
		super();
		
	}

	public Produit(long id, String libelle, int reference, double prix, int quantiteDisponible, int quantiteCritique) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.reference = reference;
		this.prix = prix;
		this.quantiteDisponible = quantiteDisponible;
		this.quantiteCritique = quantiteCritique;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getReference() {
		return reference;
	}

	public void setReference(int reference) {
		this.reference = reference;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantiteDisponible() {
		return quantiteDisponible;
	}

	public void setQuantiteDisponible(int quantiteDisponible) {
		this.quantiteDisponible = quantiteDisponible;
	}

	public int getQuantiteCritique() {
		return quantiteCritique;
	}

	public void setQuantiteCritique(int quantiteCritique) {
		this.quantiteCritique = quantiteCritique;
	}
	
}
