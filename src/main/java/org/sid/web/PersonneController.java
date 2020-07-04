package org.sid.web;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.sid.dao.PersonneRepository;
import org.sid.entities.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonneController {
	@Autowired
	private PersonneRepository personneRepository;

	@RequestMapping(value = "/user/personnes")
	public String personnes(Model model, @RequestParam(name = "motCle", defaultValue = "") String mc) {
		List<Personne> personnes = personneRepository.chercher("%" + mc + "%");
		model.addAttribute("listePersonnes", personnes);
		return "personnes";
	}
 

	@RequestMapping(value = "/admin/delete", method = RequestMethod.GET)
	public String delete(Long id) {
		personneRepository.deleteById(id);
		return "redirect:/user/personnes";
	}
	
	@RequestMapping(value = "/admin/form", method = RequestMethod.GET)
	public String formPersonne(Model model) {
		model.addAttribute("personne", new Personne());
		return "formPersonne";
	}


	@RequestMapping(value = "/admin/edit", method = RequestMethod.GET)
	public String edit(Model model, Long id) {
		Personne p = personneRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
		model.addAttribute("personne", p);
		return "editPersonne";
	}

	@RequestMapping(value = "/admin/save", method = RequestMethod.POST)
	public String addPersonne(Model model, Personne personne) {
		personneRepository.save(personne);
		return "personnes";
	}
	@RequestMapping(value = "/")
	public String home() {
		return "redirect:/user/personnes";
	}
	@RequestMapping(value = "/403")
	public String accesDenied() {
		return "403";
	}
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
}