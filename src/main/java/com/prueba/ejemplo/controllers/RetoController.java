package com.prueba.ejemplo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.ejemplo.services.RetoService;

@RestController
@RequestMapping("/api")
public class RetoController {

	@Autowired
	RetoService retoService;
	
	@GetMapping("")
	public String home() {
		return "Bienvenido";
	}
	
	@GetMapping("/reto/{array}")
	public String home(@PathVariable String array) {
		
		// return Arrays.toString(retoService.reto(array));
		return retoService.reto(array);
	}
}
