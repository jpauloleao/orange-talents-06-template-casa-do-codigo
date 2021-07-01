package br.com.zup.orange.casaDoCodigo.Livro;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/listar")
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
}
