package br.com.zup.orange.casaDoCodigo.Estado;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.util.Assert;

import br.com.zup.orange.casaDoCodigo.Pais.Pais;

@Entity
public class Estado {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotNull
    @ManyToOne
    private Pais pais;
    
    public Estado(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }
    
    @Deprecated
    public Estado() {
    }

	public String getNome() {
		return nome;
	}
    
    
}
