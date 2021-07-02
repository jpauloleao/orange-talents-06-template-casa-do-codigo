package br.com.zup.orange.casaDoCodigo.Pais;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import br.com.zup.orange.casaDoCodigo.Validacao.UniqueValue;

public class PaisDto {

	@NotBlank
	@UniqueValue(domainClass = Pais.class,fieldName = "nome")
    private String nome;
	
	@JsonCreator(mode = Mode.PROPERTIES)
	public PaisDto(@NotBlank String nome) {
		super();
		this.nome = nome;
	}
	
	public Pais converter() {
		return new Pais(this.nome);
	}
	
}
