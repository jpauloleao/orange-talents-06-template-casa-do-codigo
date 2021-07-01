package br.com.zup.orange.casaDoCodigo.Livro;

import java.util.List;
import java.util.stream.Collectors;

public class LivroListaDto {

    private Long id;
    private String titulo;

    public LivroListaDto(Livro livro) {
        id = livro.getId();
        titulo = livro.getTitulo();
	}

    @Deprecated
    public LivroListaDto() {
		// TODO Auto-generated constructor stub
	}

	public List<LivroListaDto> converter(List<Livro> livros){
    	return livros.stream().map(LivroListaDto::new).collect(Collectors.toList());
    }

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}


    
}
