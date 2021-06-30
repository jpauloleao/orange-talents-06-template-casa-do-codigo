package br.com.zup.orange.casaDoCodigo.Autor;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Não pode ser vazio!")
	private String nome;
	
	@Email(message = "Digite um email válido!")
	@NotBlank(message =  "Não pode ser vazio")
	private String email;
	
	@Size(max = 400)
	private String descricao;
	
	private LocalDateTime criacao = LocalDateTime.now();

	public Autor(@NotBlank String nome,
			@Email @NotBlank String email,
			@Size(max = 400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	private Autor() {
		// TODO Auto-generated constructor stub
	}

}
