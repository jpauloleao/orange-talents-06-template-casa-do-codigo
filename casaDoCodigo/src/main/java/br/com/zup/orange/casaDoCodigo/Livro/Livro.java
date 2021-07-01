package br.com.zup.orange.casaDoCodigo.Livro;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zup.orange.casaDoCodigo.Autor.Autor;
import br.com.zup.orange.casaDoCodigo.Categoria.Categoria;


@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
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
	private String isbn;
	
	@Future
	@NotNull
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate data;
	
	@ManyToOne
	@NotNull
	private Categoria categoria;
	
	@ManyToOne
	@NotNull
	private Autor autor;

	public Livro(@NotBlank String titulo, String sumario, @NotBlank @Length(max = 500) String resumo,
			@NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) Integer numeroPaginas, @NotNull String isbn,
			@NotNull LocalDate data, @NotNull Categoria categoria, @NotNull Autor autor) {
		super();
		this.titulo = titulo;
		this.sumario = sumario;
		this.resumo = resumo;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.data = data;
		this.categoria = categoria;
		this.autor = autor;
	}

	@Deprecated
	public Livro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTitulo() {
		return titulo;
	}

	public Long getId() {
		return id;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getSumario() {
		return sumario;
	}

	public String getIsbn() {
		return isbn;
	}

	public Autor getAutor() {
		return autor;
	}
	
	
	
	
	
	
	
}
