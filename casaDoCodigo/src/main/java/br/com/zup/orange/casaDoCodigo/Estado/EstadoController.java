package br.com.zup.orange.casaDoCodigo.Estado;

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
@RequestMapping("/estado")
public class EstadoController {
	
	@Autowired
	EntityManager em;

	@PostMapping
    @Transactional
    public ResponseEntity<?> cadastrarEstado(@RequestBody @Valid EstadoDto estadoDto) {
        Estado estado = estadoDto.converter(em);
        em.persist(estado);

        return ResponseEntity.ok("Estado Cadastrado");
    }
}
