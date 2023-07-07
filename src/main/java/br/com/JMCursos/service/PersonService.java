package br.com.JMCursos.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.JMCursos.model.Person;


//Anotação service. Significa que a classe que vai instanciar um novo objeto dessa classe, não precisa dar um "new"
//Ao invés disso, somente chamar a anotação "@Autowired" do Spring boot. Essa classe é automaticamente instânciada em tempo de execução
@Service
public class PersonService {

	private static AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	public List<Person> findAll() {
		logger.info("Finding all People");
		List<Person> persons = new ArrayList<>();
		for (int i =0;i<9; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
	}
	
	private Person mockPerson(int i) {
		logger.info("Finding one Person");
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Pessoa "+i);
		person.setLastName("Sobrenome" +i);
		person.setAdress("Rua "+i);
		person.setGender("Masculino");
		return person;
	}

	public Person findById(String id) {
		logger.info("Finding one Person");
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Joao");
		person.setLastName("Marcos");
		person.setAdress("Rua 7");
		person.setGender("Masculino");
		return person;
	}
	
	public Person create(Person person) {
		logger.info("Create new Person");
		return person;
	}
	public void delete(String id) {
		logger.info("Delete Person");

	}
	public Person update(Person person) {
		logger.info("Update Person");
		return person;
	}
	
}
