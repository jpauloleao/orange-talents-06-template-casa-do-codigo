package br.com.zup.orange.casaDoCodigo.Categoria;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	
	@Autowired
	private CategoriaRepository repository;
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrarCategoria(@RequestBody @Valid CategoriaDto categoriaDto) {
		Categoria categoria = categoriaDto.converter();
		repository.save(categoria);
		return ResponseEntity.ok().body("Cadastrado");
	}
}
