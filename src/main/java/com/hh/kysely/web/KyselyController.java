package com.hh.kysely.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.hh.kysely.domain.*;

@CrossOrigin
@RestController
@RequestMapping(path={"/", "/rest/kyselyt"})
public class KyselyController
{
	@Autowired
	private KyselyRepo repository; 
		
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

    // Add
    @RequestMapping(value = "/add")
    public String addKysely(Model model)
    {
    	model.addAttribute("kysely", new Kysely());
        return "add";
    }     

    // Save
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Kysely kysely)
    {
        repository.save(kysely);
        return "redirect: rest/kyselyt";
    }    

    // Delete
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteQuestion(@PathVariable("id") Long id, Model model)
    {
    	repository.deleteById(id);
        return "redirect:../kysely";
    }  
    
    // Edit
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editQuestion(@PathVariable("id") Long id, Model model)
    {
    	model.addAttribute("question", repository.findById(id));
    	return "edit";
    }
    
    //Avaa kysely
    @RequestMapping(value="/kysely/{id}", method = RequestMethod.GET)
    public String kys(Model model)
    {
    	model.addAttribute("kysely", repository.findAll());
    	return "kysely";
    }
    
	//Lisää kysymys kyselyyn
    @RequestMapping(value = "/{id}/addquestion")
    public String addKysymys(Model model)
    {
    	model.addAttribute("kysymys", new Kysymys());
    	return "addquestion";
    }
}
