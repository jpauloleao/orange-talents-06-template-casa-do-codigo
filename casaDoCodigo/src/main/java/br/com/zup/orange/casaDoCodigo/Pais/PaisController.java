package br.com.zup.orange.casaDoCodigo.Pais;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/pais")
@RestController
public class PaisController {
	
	@Autowired
	private PaisRepository repository; 

	@PostMapping
    @Transactional
    public ResponseEntity<?> cadastrarPais(@RequestBody @Valid PaisDto paisDto) {
        Pais pais = paisDto.converter();
        repository.save(pais);
        return ResponseEntity.ok("Pais Cadastrado");
    }
	
}
