package br.com.JMCursos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.JMCursos.models.Person;
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
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable(value = "id") Long id) {
		return personService.findById(id);
		
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll() {
		return personService.findAll();
		
	}
	
	//consome e produz JSON,
	//anotação @RequestBody = valores que passamos no body da requisição
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Person create(@RequestBody Person person) {
		return personService.create(person);
		
	}
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public void delete(@PathVariable(value= "id") Long id) {
		personService.delete(id);
		
	}
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public Person update(@RequestBody Person person) {
		return personService.update(person);
		
	}
}
