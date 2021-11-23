package com.hh.kysely.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
	  @RequestMapping(method = RequestMethod.POST)
	    public @ResponseBody Vastaus saveVastausRest(@RequestBody Vastaus vastaus) {	
	    	return vastausrepo.save(vastaus);
	    }

}
