package com.hh.kysely.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hh.kysely.domain.Kysymys;
import com.hh.kysely.domain.KysymysRepo;

@CrossOrigin
@RestController
@RequestMapping(path= "/rest/kysymykset")

public class KysymysRestController {
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
	    public Kysymys saveKysymysRest(@RequestBody Kysymys kysymys) {	
	    	return kysymysrepo.save(kysymys);
	    }
	
	
	
	 
    
    
	
}


