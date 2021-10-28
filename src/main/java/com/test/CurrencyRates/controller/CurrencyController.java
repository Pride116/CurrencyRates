package com.test.CurrencyRates.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.CurrencyRates.service.CurrencyService;

@Controller
@RequestMapping("/rates")
public class CurrencyController {
	
	@Autowired
	private CurrencyService service;
	
	
	@GetMapping("/usd")
	public String rates(Model model) {
		
		model.addAttribute("rates",service.getRates());
		return "Rates";
	}

}
