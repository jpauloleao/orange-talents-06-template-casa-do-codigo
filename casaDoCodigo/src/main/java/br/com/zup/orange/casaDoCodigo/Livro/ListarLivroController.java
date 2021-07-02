package br.com.zup.orange.casaDoCodigo.Livro;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RequestMapping("/livro")
@RestController
public class ListarLivroController {
	
	@Autowired
	private LivroRepository lv;
	
	@GetMapping("/todos")
	@Transactional
	public List<LivroListaDto> listarLivros(){
		LivroListaDto livro = new LivroListaDto();
		return livro.converter(lv.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> listarLivro(@PathVariable Long id){
		LivroDetalhesDto livro = new LivroDetalhesDto();
		if(livro.converter(id, lv) == null) {
			return ResponseEntity.notFound().build();
		}
		System.out.println(livro);
		return ResponseEntity.ok(livro.converter(id, lv));
	}
}
