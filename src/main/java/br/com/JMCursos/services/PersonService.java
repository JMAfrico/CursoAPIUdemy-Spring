package br.com.JMCursos.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.JMCursos.exception.ResourceNotFoundException;
import br.com.JMCursos.models.Person;
import br.com.JMCursos.repositories.PersonRepository;


//Anotação service. Significa que a classe que vai instanciar um novo objeto dessa classe, não precisa dar um "new"
//Ao invés disso, somente chamar a anotação "@Autowired" do Spring boot. Essa classe é automaticamente instânciada em tempo de execução
@Service
public class PersonService {

//	private static AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	@Autowired
	PersonRepository personRepository;
	
	public List<Person> findAll() {
		logger.info("Finding all People");
//		List<Person> persons = new ArrayList<>();
//		for (int i =0;i<9; i++) {
//			Person person = mockPerson(i);
//			persons.add(person);
//		}
		return personRepository.findAll();
//		return persons;
	}
	
//	private Person mockPerson(int i) {
//		logger.info("Finding one Person");
//		Person person = new Person();
//		person.setId(counter.incrementAndGet());
//		person.setFirstName("Pessoa "+i);
//		person.setLastName("Sobrenome" +i);
//		person.setAdress("Rua "+i);
//		person.setGender("Masculino");
//		return person;
//	}

	public Person findById(Long id) {
		logger.info("Finding one Person");
//		Person person = new Person();
//		person.setId(counter.incrementAndGet());
//		person.setFirstName("Joao");
//		person.setLastName("Marcos");
//		person.setAdress("Rua 7");
//		person.setGender("Masculino");
		return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Records found for this id"));
	}
	
	public Person create(Person person) {
		logger.info("Create new Person");
		return personRepository.save(person);
	}

	public Person update(Person person) {
		logger.info("Update Person");
		Person entity = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No Records found for this id"));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAdress(person.getAdress());
		entity.setGender(person.getGender());
		return personRepository.save(entity);
	}
	
	public void delete(Long id) {
		logger.info("Delete Person");
		Person entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Records found for this id"));
		personRepository.delete(entity);
	}
	
}
