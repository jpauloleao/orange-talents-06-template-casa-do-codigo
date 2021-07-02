package br.com.zup.orange.casaDoCodigo.Estado;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.util.Assert;

import br.com.zup.orange.casaDoCodigo.Pais.Pais;
import br.com.zup.orange.casaDoCodigo.Validacao.ObjectExists;

public class EstadoDto {

	@NotBlank
    private String nome;
	
    @NotNull
	@ObjectExists(domainClass = Pais.class, fieldName = "id")
    private Long idPais;

    
	public EstadoDto(@NotBlank String nome, @NotNull Long idPais) {
		this.nome = nome;
		this.idPais = idPais;
	} 
    
	public Estado converter(EntityManager em) {
		Pais pais = em.find(Pais.class, idPais);

        //Verificação se estado já pertence ao País
        Query query = em.createQuery("from Estado where nome='" + nome + "' and pais_id=" + idPais);
        List<?> lista = query.getResultList();
        Assert.state(lista.isEmpty(), "O estado " + nome + " já está registrado no(a) "  + pais.getNome() );

        return new Estado(nome, pais);
    }
	
}
