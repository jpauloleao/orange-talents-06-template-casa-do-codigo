package br.com.zup.orange.casaDoCodigo.Autor;

public class AutorLivroDto {
	
	  	private String nome;
	    private String descricao;

	    public AutorLivroDto(Autor autor) {
	        this.nome = autor.getNome();
	        this.descricao = autor.getDescricao();
	    }

		public String getNome() {
			return nome;
		}

		public String getDescricao() {
			return descricao;
		}

}
