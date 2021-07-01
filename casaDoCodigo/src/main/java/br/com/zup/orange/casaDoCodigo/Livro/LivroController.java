package br.com.zup.orange.casaDoCodigo.Livro;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/livro")
@RestController
public class LivroController {

	@Autowired
	private EntityManager em;
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrarLivro(@RequestBody @Valid LivroDto livroDto){
		
		Livro livro = livroDto.converter(em);
		em.persist(livro);
		
		return ResponseEntity.ok("Livro Cadastrado");
	}
}
