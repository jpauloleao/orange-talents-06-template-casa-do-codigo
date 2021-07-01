package br.com.zup.orange.casaDoCodigo.Livro;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


public interface LivroRepository extends CrudRepository<Livro, Long>  {
	public List<Livro> findAll();
	
	public Optional<Livro> findById(Long id);
}
