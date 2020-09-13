package com.springproject.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springproject.crud.model.Product;
import com.springproject.crud.service.ProductService;
@Controller
public class HomeController {
	@Autowired
	private ProductService service;
	
	
	@RequestMapping("/")
	public String homePage(Model model) {
		List<Product>  listProducts=service.listAll();
	model.addAttribute("products",listProducts);
	return "index";
	
	}
	@RequestMapping("/new")
	public String createProduct(Model model) {
		Product product = new Product();
		model.addAttribute("product" ,product);
		
		return "new_product";
		
	}
	@PostMapping("/save")
	public String saveproduct(@ModelAttribute("product") Product product) {
		service.save(product);
		return "redirect:/";
	}
		@RequestMapping("/edit/{id}")
		public ModelAndView edit(@PathVariable("id")Long id) {
			ModelAndView mav=new ModelAndView("edit_product");
			Product product=service.get(id);
			mav.addObject("product",product);
			return mav;

			
			
		}
		@RequestMapping("/delete/{id}")
		public String delete(@PathVariable("id")Long id) {
			service.delete(id);
			return "redirect:/";
			
			
		}
		
	}

