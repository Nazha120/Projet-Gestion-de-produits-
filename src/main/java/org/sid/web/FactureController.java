package org.sid.web;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.sid.dao.FactureRepository;
import org.sid.entities.Facture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class FactureController {
	@Autowired
	private FactureRepository factureRepository;

	@RequestMapping(value = "/user/factures")
	
	public String factures(Model model, @RequestParam(name = "motCle", defaultValue = "") String mc) {
		List<Facture> factures = factureRepository.chercher("%" + mc + "%");
		model.addAttribute("listeFacture", factures);
		return "factures";
	}  
	@RequestMapping(value = "/admin/deleteFacture", method = RequestMethod.GET)
	public String delete(Long id) {
		factureRepository.deleteById(id);
		return "redirect:/user/factures";
	}
	@RequestMapping(value = "/admin/editFacture", method = RequestMethod.GET)
	public String edit(Model model, Long id) {
		Facture f = factureRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
		model.addAttribute("facture", f);  
		return "editFacture";
	}
	
	@RequestMapping(value = "/admin/formFacture", method = RequestMethod.GET)
	public String formFacture(Model model) {
		model.addAttribute("facture", new Facture());
		return "formFacture";
	}
	@RequestMapping(value = "/admin/saveFacture", method = RequestMethod.POST)
	public String addProduit(Model model, Facture facture) {
		 factureRepository.save(facture);
		return "factures";
	}
	

	
	
}