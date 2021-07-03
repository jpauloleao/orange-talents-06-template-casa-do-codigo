package br.com.zup.orange.casaDoCodigo.Cliente;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	EntityManager em;

	@PostMapping
    @Transactional
    public ResponseEntity<?> cadastrarCliente(@RequestBody @Valid ClienteDto clienteDto) {
        Cliente cliente = clienteDto.converter(em);
        em.persist(cliente);

        return ResponseEntity.ok("Cliente de id:" + new ClienteResponseDto(cliente).getId() + " cadastrado");
    }
}
