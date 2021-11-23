package com.hh.kysely.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hh.kysely.domain.Vastaus;
import com.hh.kysely.domain.VastausRepo;

@CrossOrigin
@RestController
@RequestMapping(path="/rest/vastaukset")
public class VastausController {
	@Autowired VastausRepo vastausrepo;
	
	@RequestMapping (method = RequestMethod.GET) 
	public List<Vastaus> haeVastaus () {
		return vastausrepo.findAll();
	}
	
	 @RequestMapping(value="/{id}", method = RequestMethod.GET)
	    public @ResponseBody Optional<Vastaus> findVastausRest(@PathVariable("id") Long id)
	    {	
	    	return vastausrepo.findById(id);
	    }    
	
	  @RequestMapping(method = RequestMethod.POST)
	    public @ResponseBody Vastaus saveVastausRest(@RequestBody Vastaus vastaus) {	
	    	return vastausrepo.save(vastaus);
	    }

}
