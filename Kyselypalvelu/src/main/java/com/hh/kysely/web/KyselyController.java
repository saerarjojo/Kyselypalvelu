package com.hh.kysely.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.hh.kysely.domain.*;

@CrossOrigin
@Controller
public class KyselyController
{
	@Autowired
	private KyselyRepo repository; 
		
	// Show all
    @RequestMapping(value= {"/", "/kyselyt"})
    public String kysely(Model model)
    {	
        model.addAttribute("kysely", repository.findAll());
        return "kyselyt";
    }
    
    // RESTful service to get all
    @RequestMapping(value="/questions", method = RequestMethod.GET)
    public @ResponseBody List<Kysely> KyselyRepo()
    {	
        return (List<Kysely>) repository.findAll();
    }    

	 //RESTful service to get by id
    @RequestMapping(value="/restkysely/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Kysely> findQuestionRest(@PathVariable("id") Long id)
    {	
    	return repository.findById(id);
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
        return "redirect:kyselyt";
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
    
  //Open a questionnaire
    @RequestMapping(value="/kysely/{id}", method = RequestMethod.GET)
    public String kys(Model model)
    {
    	model.addAttribute("kysely", repository.findAll());
    	return "kysely";
    }
    //add a question
    @RequestMapping(value = "/kysely/{id}/addquestion")
    public String addQuestion(Model model)
    {
    	model.addAttribute("kysymys", new Kysymys());
    	return "addquestion";
    }

}
