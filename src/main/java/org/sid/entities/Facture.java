package org.sid.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Facture implements Serializable {
	@Id
	@GeneratedValue
	private int id;
	private Date dateFacture;
	private String statut;
	private double montantTotal;
	@OneToMany
	private Collection<Devis> devis;
	public Facture() {
		super();
	}
	public Facture(int id, Date dateFacture, String statut, double montantTotal, Collection<Devis> devis) {
		super();
		this.id = id;
		this.dateFacture = dateFacture;
		this.statut = statut;
		this.montantTotal = montantTotal;
		this.devis = devis;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDateFacture() {
		return dateFacture;
	}
	public void setDateFacture(Date dateFacture) {
		this.dateFacture = dateFacture;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public double getMontantTotal() {
		return montantTotal;
	}
	public void setMontantTotal(double montantTotal) {
		this.montantTotal = montantTotal;
	}
	public Collection<Devis> getDevis() {
		return devis;
	}
	public void setDevis(Collection<Devis> devis) {
		this.devis = devis;
	}
	
	
}