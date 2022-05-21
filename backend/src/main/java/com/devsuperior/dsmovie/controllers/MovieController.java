package com.devsuperior.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmovie.DTO.MovieDTO;
import com.devsuperior.dsmovie.services.MovieService;


// aqui é o controller, responsável por responder uma requisição



@RestController
@RequestMapping(value="/movies") // mapeamento do filmes, retorna um json
public class MovieController {
	
	@Autowired
	private MovieService service; // instancia um service
	
	@GetMapping 
	public Page<MovieDTO> findAll(Pageable pageable) {	// retorno padrão se não passar
		//o id
		
		return service.findAll(pageable);		
	}
	
	
	@GetMapping(value = "/{id}") 
	public MovieDTO findByID(@PathVariable Long id ) {	// passando o id ele retorna somente o id
		
		return service.findbyID(id);	
		
	}
	
	
	

}
 