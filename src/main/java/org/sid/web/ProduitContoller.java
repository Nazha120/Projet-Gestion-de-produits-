package org.sid.web;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.sid.dao.ProduitRepository;
import org.sid.entities.Devis;
import org.sid.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class ProduitContoller {
	@Autowired
	private ProduitRepository produitRepository;

	@RequestMapping(value = "/user/produits")
	//public String produits() {
	public String produits(Model model, @RequestParam(name = "motCle", defaultValue = "") String mc) {
		List<Produit> produits = produitRepository.chercher("%" + mc + "%");
		model.addAttribute("listeProduit", produits);
		return "produits";
	}  
	@RequestMapping(value = "/admin/deleteProduit", method = RequestMethod.GET)
	public String delete(Long id) {
		produitRepository.deleteById(id);
		return "redirect:/user/produits";
	}
	@RequestMapping(value = "/admin/editProduit", method = RequestMethod.GET)
	public String edit(Model model, Long id) {
		Produit p = produitRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
		model.addAttribute("produit", p);  
		return "editProduit";
	}
	
	@RequestMapping(value = "/admin/formProduit", method = RequestMethod.GET)
	public String formProduit(Model model) {
		model.addAttribute("produit", new Produit());
		return "formProduit";
	}
	@RequestMapping(value = "/admin/saveProduit", method = RequestMethod.POST)
	public String addProduit(Model model, Produit produit) {
		 produitRepository.save(produit);
		return "produits";
	}
	

	
	
}
	
	