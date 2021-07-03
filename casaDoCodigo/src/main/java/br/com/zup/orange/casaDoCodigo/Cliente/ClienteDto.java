package br.com.zup.orange.casaDoCodigo.Cliente;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.persistence.Query;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.util.Assert;

import br.com.zup.orange.casaDoCodigo.Estado.Estado;
import br.com.zup.orange.casaDoCodigo.Pais.Pais;
import br.com.zup.orange.casaDoCodigo.Validacao.Documento;
import br.com.zup.orange.casaDoCodigo.Validacao.ObjectExists;
import br.com.zup.orange.casaDoCodigo.Validacao.UniqueValue;

public class ClienteDto {

	@NotBlank
	@Email
	@UniqueValue(domainClass = Cliente.class, fieldName = "email")
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@NotBlank
	@UniqueValue(domainClass = Cliente.class, fieldName = "documento")
	@Documento(message = "Documento Inválido")
	private String documento;

	@NotBlank
	private String endereco;

	@NotBlank
	private String complemento;

	@NotBlank
	private String cidade;

	@NotNull
	@ObjectExists(domainClass = Pais.class, fieldName = "id")
	private Long idPais;

	private Long idEstado;

	@NotBlank
	private String telefone;

	@NotBlank
	private String cep;

	public ClienteDto(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotNull Long idPais, Long idEstado, @NotBlank String telefone,
			@NotBlank String cep) {
		super();
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.idPais = idPais;
		this.idEstado = idEstado;
		this.telefone = telefone;
		this.cep = cep;
	}

	public Cliente converter(EntityManager em) {

		@NotNull
		Pais pais = em.find(Pais.class, idPais);

		Cliente cliente = new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, pais, telefone,
				cep);		

		if (idEstado == null) {
			Assert.state(verificaPaisComEstados(em), "O estado não deveria ser nulo para esse país");
		} else {
			Assert.state(em.find(Estado.class, idEstado) != null, "O estado não existe");
			Assert.state(verificaEstadoPais(em), "O estado não faz parte do país ");

			Estado estado = em.find(Estado.class, idEstado);
			cliente.setEstado(estado);

		}

		return cliente;
	}

	// Teste para saber se Estado faz parte do Pais
	private boolean verificaEstadoPais(EntityManager em) {
		Query q = em.createQuery("select 1 from Estado where id=:IdEstado and pais_id=:IdPais");
		q.setParameter("IdPais", idPais);
		q.setParameter("IdEstado", idEstado);
		List<?> l = q.getResultList();
		return l.size() >= 1;
	}
	
	// Verifica se o pais possui estados
	private boolean verificaPaisComEstados(EntityManager em) {
		Query query = em.createQuery("select 1 from Estado where pais_id=:IdPais");
		query.setParameter("IdPais", idPais);
		List<?> lista = query.getResultList();
		
		return lista.size() == 0;
	}
}
