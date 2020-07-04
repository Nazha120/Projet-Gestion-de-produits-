package org.sid.web;


import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.sid.dao.DevisRepository;
import org.sid.entities.Devis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DevisController {
		@Autowired
		private DevisRepository devisRepository;

		@RequestMapping(value = "/user/devis")
		public String devis(Model model, @RequestParam(name = "motCle", defaultValue = "") String mc) {
			List<Devis> devis = devisRepository.chercher("%" + mc + "%");
			model.addAttribute("listeDevis", devis);
			return "devis";
		}  
		@RequestMapping(value = "/admin/deleteDevis", method = RequestMethod.GET)
		public String delete(Long id) {
			devisRepository.deleteById(id);
			return "redirect:/user/devis";
		}
		@RequestMapping(value = "/admin/editDevis", method = RequestMethod.GET)
		public String edit(Model model, Long id) {
			Devis d = devisRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
			model.addAttribute("devis", d);  
			return "editDevis";
		}
		
		
		@RequestMapping(value = "/admin/saveDevis", method = RequestMethod.POST)
		public String addDevis(Model model, Devis devis) {
			 devisRepository.save(devis);
			return "devis";
		}

		@RequestMapping(value = "/admin/formDevis", method = RequestMethod.GET)
		public String formDevis(Model model) {
			model.addAttribute("devis", new Devis());
			return "formDevis";
		}
	}


