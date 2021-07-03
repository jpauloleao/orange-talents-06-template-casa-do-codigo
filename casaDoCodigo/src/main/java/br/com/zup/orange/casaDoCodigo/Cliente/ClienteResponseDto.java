package br.com.zup.orange.casaDoCodigo.Cliente;

public class ClienteResponseDto {
	
	Long id;
	
	public ClienteResponseDto(Cliente cliente) {
		this.id = cliente.getId();
	}

	public Long getId() {
		return id;
	}
	
	
}
