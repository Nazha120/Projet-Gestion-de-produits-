package org.sid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Devis implements Serializable {
	@Id
	@GeneratedValue
	private long id;
    private Date dateDevis;
    private double prixDevis;
    private String quantite;
    private double montantTotal;
	public Devis() {
		super();
		
	}
	public Devis(long id, Date dateDevis, double prixDevis, String quantite, double montantTotal) {
		super();
		this.id = id;
		this.dateDevis = dateDevis;
		this.prixDevis = prixDevis;
		this.quantite = quantite;
		this.montantTotal = montantTotal;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDateDevis() {
		return dateDevis;
	}
	public void setDateDevis(Date dateDevis) {
		this.dateDevis = dateDevis;
	}
	public double getPrixDevis() {
		return prixDevis;
	}
	public void setPrixDevis(double prixDevis) {
		this.prixDevis = prixDevis;
	}
	public String getQuantite() {
		return quantite;
	}
	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}
	public double getMontantTotal() {
		return montantTotal;
	}
	public void setMontantTotal(double montantTotal) {
		this.montantTotal = montantTotal;
	}
    
}