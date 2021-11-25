package com.hh.kysely.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.hh.kysely.domain.Kysymys;
import com.hh.kysely.domain.KysymysRepo;
import com.hh.kysely.domain.Vastaus;


@CrossOrigin
@RestController
@RequestMapping(path= "/rest/kysymykset")
public class KysymysController {
	@Autowired
	private KysymysRepo kysymysrepo;
	

	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Kysymys> haeKaikki() {
		return kysymysrepo.findAll();
	}
	
	 @RequestMapping(value="/{id}", method = RequestMethod.GET)
	    public Optional<Kysymys> findKysymysRest(@PathVariable("id") Long id)
	    {	
	    	return kysymysrepo.findById(id);
	    }

	@RequestMapping(method = RequestMethod.POST)
	    public Kysymys saveKysymysRest(Kysymys kysymys) {	
	    	return kysymysrepo.save(kysymys);
	    }
	
	//Lisää vastaus kysymykseen
    @RequestMapping(value = "/{id}/addanswer")
    public String addVastaus(Model model)
    {
    	model.addAttribute("vastaus", new Vastaus());
    	return "addanswer";
    }
	
}