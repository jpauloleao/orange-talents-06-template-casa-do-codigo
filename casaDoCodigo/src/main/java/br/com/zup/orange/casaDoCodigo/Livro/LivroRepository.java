package br.com.zup.orange.casaDoCodigo.Livro;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.zup.orange.casaDoCodigo.Autor.Autor;
import br.com.zup.orange.casaDoCodigo.Categoria.Categoria;

public interface LivroRepository extends CrudRepository<Livro, Long>  {
	public List<Livro> findAll();
}
