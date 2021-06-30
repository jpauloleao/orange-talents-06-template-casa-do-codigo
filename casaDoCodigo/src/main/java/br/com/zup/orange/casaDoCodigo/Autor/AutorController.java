package br.com.zup.orange.casaDoCodigo.Autor;


import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	private AutorRepository repository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrarAutor(@RequestBody @Valid AutorDto autorDto) {
		Autor autor = autorDto.converter();
		repository.save(autor);
		
		return ResponseEntity.ok().body(autor);
	}
	
	
}
