package com.hh.kysely.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hh.kysely.domain.*;

@CrossOrigin
@RestController
@RequestMapping (path= "/rest/kyselyt")

public class KyselyRestController {

	@Autowired private KyselyRepo repository; 
	
    // RESTful service to get all
    @RequestMapping(method = RequestMethod.GET)
    public List<Kysely> KyselyRepo()
    {	
        return repository.findAll();
    }    

	 //RESTful service to get by id
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Optional<Kysely> findQuestionRest(@PathVariable("id") Long id)
    {	
    	return repository.findById(id);
    }    
    
    @RequestMapping(method = RequestMethod.POST)
    public Kysely saveKyselyRest(Kysely kysely) {
    	return repository.save(kysely);
    }
}
