package com.hh.kysely.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hh.kysely.domain.Kysymys;
import com.hh.kysely.domain.KysymysRepo;


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
	
	  @RequestMapping(method = RequestMethod.POST)
	    public @ResponseBody Kysymys saveKysymysRest(@RequestBody Kysymys kysymys) {	
	    	return kysymysrepo.save(kysymys);
	    }
	
} 
