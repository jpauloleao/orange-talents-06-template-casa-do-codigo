package br.com.zup.orange.casaDoCodigo.Pais;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;
    
    public Pais(String nome) {
        this.nome = nome;
    }

    @Deprecated
	public Pais() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}
    

}
