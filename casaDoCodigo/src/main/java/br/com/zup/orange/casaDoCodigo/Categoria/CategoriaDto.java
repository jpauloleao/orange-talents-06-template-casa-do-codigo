package br.com.zup.orange.casaDoCodigo.Categoria;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;


import br.com.zup.orange.casaDoCodigo.validacao.UniqueValue;

public class CategoriaDto {

	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
	private String nome;

	
	
	@JsonCreator(mode = Mode.PROPERTIES)
	public CategoriaDto(@NotBlank String nome) { 
		this.nome = nome; 
	}
	 

	public Categoria converter() {
		return new Categoria(this.nome);
	}


	public String getNome() {
		return nome;
	}

	
}
