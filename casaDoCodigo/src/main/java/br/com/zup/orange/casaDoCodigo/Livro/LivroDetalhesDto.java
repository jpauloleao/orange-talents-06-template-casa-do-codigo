package br.com.zup.orange.casaDoCodigo.Livro;

import java.util.Optional;


import br.com.zup.orange.casaDoCodigo.Autor.AutorLivroDto;


public class LivroDetalhesDto {
	
    private String sumario;
    private String titulo;
    private Integer numeroPaginas;
    private AutorLivroDto autor;


    public LivroDetalhesDto(Livro livro) {
        titulo = livro.getTitulo();
        sumario = livro.getSumario();
        numeroPaginas = livro.getNumeroPaginas();
        autor = new AutorLivroDto(livro.getAutor());
	}

    @Deprecated
    public LivroDetalhesDto() {
		// TODO Auto-generated constructor stub
	}

	public LivroDetalhesDto converter(Long id, LivroRepository lm){
		Optional<Livro> livro = lm.findById(id);
		if(livro.isEmpty()) {
			return null;
		}
    	return new LivroDetalhesDto(livro.get());
    }

	public String getTitulo() {
		return titulo;
	}

	public String getSumario() {
		return sumario;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public AutorLivroDto getAutor() {
		return autor;
	}

   
}
