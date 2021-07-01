package br.com.zup.orange.casaDoCodigo.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zup.orange.casaDoCodigo.Autor.Autor;
import br.com.zup.orange.casaDoCodigo.Categoria.Categoria;
import br.com.zup.orange.casaDoCodigo.Validacao.UniqueValue;
import br.com.zup.orange.casaDoCodigo.Validacao.ObjectExists;

public class LivroDto {

	
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo")
	private String titulo;
	
	private String sumario;
	
	@NotBlank
	@Length(max = 500)
	private String resumo; 
	
	@NotNull
	@Min(20)
	private BigDecimal preco;
	
	@NotNull
	@Min(100)
	private Integer numeroPaginas;
	
	@NotNull
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn")
	private String isbn;
	
	@Future
	@NotNull
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate data;
	
	@NotNull
	@ObjectExists(domainClass = Categoria.class, fieldName = "id")
	private Long idCategoria;
	
	@NotNull
	@ObjectExists(domainClass = Autor.class, fieldName = "id")
	private Long idAutor;

	@JsonCreator
	public LivroDto(@NotBlank String titulo, String sumario, @NotBlank @Length(max = 500) String resumo,
			@NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) Integer numeroPaginas, @NotNull String isbn,
			@NotNull @Future LocalDate data, @NotNull Long idCategoria, @NotNull Long idAutor) {
		super();
		this.titulo = titulo;
		this.sumario = sumario;
		this.resumo = resumo;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.data = data;
		this.idCategoria = idCategoria;
		this.idAutor = idAutor;
	}

	public Livro converter(EntityManager em) {
		
		@NotNull Autor autor = em.find(Autor.class, idAutor);
		 
		@NotNull Categoria categoria = em.find(Categoria.class, idCategoria);
		
		
		return new Livro(titulo, sumario, resumo, preco, numeroPaginas, isbn, data, categoria, autor);
	}
	
}
