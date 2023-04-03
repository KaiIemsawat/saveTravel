package com.mvc.saveTravel.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.saveTravel.models.Travel;
import com.mvc.saveTravel.services.TravelService;

@Controller
@RequestMapping("/expenses")
public class TravelController {

	@Autowired
	private TravelService tServ;
	

	@GetMapping
	public String index(Model model, @ModelAttribute("travel") Travel travel) {
		
//		Create a list of object type Travel
		List<Travel> travels = tServ.getAllTravel();
		model.addAttribute("travels", travels);
		return "index.jsp";
	}
	
	
	@PostMapping()
	public String addExpense(
			@Valid @ModelAttribute("travel") Travel travel
			, BindingResult result
			, Model model
			) {
//		If there is any error, return the 'index,jsp
		if(result.hasErrors()) {
			model.addAttribute("travels", tServ.getAllTravel());
			return "index.jsp";
		}
//		If there is no error create (and save) it
		tServ.createTravel(travel);
		return "redirect:/expenses";
	}
	
	
	@GetMapping("/edit/{id}")
	public String toEdit(@PathVariable("id") Long id, Model model) {
		model.addAttribute("travel", tServ.getTravelById(id));
		return "edit.jsp";
	}
	
	@PutMapping("/edit/{id}")
	public String editing(
			@PathVariable("id") Long id
			, @Valid @ModelAttribute("travel") Travel travel
			, BindingResult res
			, Model model
			) {
//		Return the page that includes information
		if(res.hasErrors()) {
			model.addAttribute("travels", tServ.getAllTravel());
			return "edit.jsp";
		}
//		Edit, save, and return to main page
		tServ.createTravel(travel);
		return "redirect:/expenses";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteItem(@PathVariable("id") Long id) {
		
		tServ.deleteById(id);
		return "redirect:/expenses";
	}
	
}
