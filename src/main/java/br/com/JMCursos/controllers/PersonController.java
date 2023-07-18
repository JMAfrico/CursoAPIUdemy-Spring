package br.com.JMCursos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.JMCursos.data.vo.v1.PersonVO;
import br.com.JMCursos.services.PersonService;
import br.com.JMCursos.utils.UtilitariosMath;

@RestController
@RequestMapping("/person")
public class PersonController {

	//Anotação @Autowired. Significa que a classe que foi chamada vai ser instanciada sem necessidade de dar um "new". Executada em tempo de execução
	//A classe chamada deve conter a anotação @Service
	@Autowired
	private PersonService personService;
	UtilitariosMath operacao = new UtilitariosMath();
	
	
	//id= path, method= get, produz JSON,
	//anotação @PathVariable = valores que passamos por parametro na URL
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVO findById(@PathVariable(value = "id") Long id) {
		return personService.findById(id);
		
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PersonVO> findAll() {
		return personService.findAll();
		
	}
	
	//consome e produz JSON,
	//anotação @RequestBody = valores que passamos no body da requisição
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public PersonVO create(@RequestBody PersonVO person) {
		return personService.create(person);
		
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value= "id") Long id) {
		personService.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public PersonVO update(@RequestBody PersonVO person) {
		return personService.update(person);
		
	}
}
