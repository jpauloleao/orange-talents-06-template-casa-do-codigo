package br.com.zup.orange.casaDoCodigo.autor;



import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class AutorDto {

	@NotBlank(message = "Não pode ser vazio!")
	private String nome;
	
	@Email(message = "Digite um email válido!")
	@NotBlank(message =  "Não pode ser vazio")
	private String email;
	
	@Size(max = 400)
	private String descricao;

	public AutorDto(@NotBlank(message = "Não pode ser vazio!") String nome,
			@Email(message = "Digite um email válido!") @NotBlank(message = "Não pode ser vazio") String email,
			@Size(max = 400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}
	

	@Override
	public String toString() {
		return "AutorDto [nome=" + nome + ", email=" + email + ", descricao=" + descricao + "]";
	}


	public Autor converter() {
		return new Autor(this.nome, this.email, this.descricao);
	}
	

	
	
}
