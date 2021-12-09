package com.hh.kysely.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.hh.kysely.domain.Kysely;
import com.hh.kysely.domain.Kysymys;
import com.hh.kysely.domain.KysymysRepo;
import com.hh.kysely.domain.Vastaus;


@Controller
public class KysymysController {
	@Autowired
	private KysymysRepo kysymysrepo;
	

	
	 //add a question
    @RequestMapping(value = "/kysely/{id}/addquestion")
    public String addQuestion(Model model, @PathVariable Long id)
    {
    	System.out.println("kyselyn id " + id);
    	//luo kyselyolio,
    	Kysely kysely = new Kysely();
    	//aseta kyselyoliolle parametrinä tullut kyselyid arvo
    	kysely.setKyselyid(id);
    	Kysymys kysymys = new Kysymys();
    	kysymys.setKysely(kysely);
    	model.addAttribute("kysymys", kysymys);
    	
    	
    	
    	//välitä kyselyolio modelin alle
    	//model.addAttribute("kysely", kysely);
    	return "addquestion";
    }
    
    @RequestMapping(value = "/savequestion", method = RequestMethod.POST)
    public String saveQuestion(Kysymys kysymys)
    {
    	kysymysrepo.save(kysymys);
    	return "redirect:kyselyt";
    	//return "redirect:kysely/{id}"
    	 
    }
	
	//Lisää vastaus kysymykseen
    @RequestMapping(value = "/{id}/addanswer")
    public String addVastaus(Model model)
    {
    	model.addAttribute("vastaus", new Vastaus());
    	return "addanswer";
    }
	
}
