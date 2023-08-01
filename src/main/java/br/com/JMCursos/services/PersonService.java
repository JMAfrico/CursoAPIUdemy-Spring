package br.com.JMCursos.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.JMCursos.data.vo.v1.PersonVO;
import br.com.JMCursos.data.vo.v2.PersonVOV2;
import br.com.JMCursos.exception.ResourceNotFoundException;
import br.com.JMCursos.mapper.DozerMapper;
import br.com.JMCursos.mapper.custom.PersonMapper;
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
	
	@Autowired
	PersonMapper personMapper;
	
	public List<PersonVO> findAll() {
		logger.info("Finding all People");
//		return personRepository.findAll();
		//utizando o mapper list, buscamos a entidade que queremos,e passamos a classe que queremos que ele siga os dados
		return DozerMapper.parseListObject(personRepository.findAll(), PersonVO.class);

	}
	
//	private PersonVo mockPerson(int i) {
//		logger.info("Finding one PersonVo");
//		PersonVo person = new PersonVo();
//		person.setId(counter.incrementAndGet());
//		person.setFirstName("Pessoa "+i);
//		person.setLastName("Sobrenome" +i);
//		person.setAdress("Rua "+i);
//		person.setGender("Masculino");
//		return person;
//	}

	public PersonVO findById(Long id) {
		logger.info("Finding one PersonVo");
//		PersonVo person = new PersonVo();
//		person.setId(counter.incrementAndGet());
//		person.setFirstName("Joao");
//		person.setLastName("Marcos");
//		person.setAdress("Rua 7");
//		person.setGender("Masculino");
//		return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Records found for this id"));
		var entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Records found for this id"));
		return DozerMapper.parseObject(entity,PersonVO.class);

	}
	
	public PersonVO create(PersonVO personVo) {
		logger.info("Create new PersonVo");
//		return personRepository.save(person);
		//Recupera o objeto correto, converte para entity, salva no banco e retorna novamento o mapper
		var entity = DozerMapper.parseObject(personVo,Person.class);
		var vo = DozerMapper.parseObject(personRepository.save(entity),PersonVO.class);
		return vo;

	}

	public PersonVO update(PersonVO person) {
		logger.info("Update PersonVo");
		var entity = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No Records found for this id"));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAdress(person.getAdress());
		entity.setGender(person.getGender());
//		return personRepository.save(entity);
		var vo = DozerMapper.parseObject(personRepository.save(entity),PersonVO.class);
		return vo;
		
	}
	
	public void delete(Long id) {
		logger.info("Delete PersonVo");
		var entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Records found for this id"));
		personRepository.delete(entity);
	}

	public PersonVOV2 createV2(PersonVOV2 person) {
		logger.info("Create new PersonVo");
//		return personRepository.save(person);
		//Recupera o objeto correto, converte para entity, salva no banco e retorna novamento o mapper
		var entity = personMapper.convertVoToEntity(person);
		var vo = personMapper.convertEntityToVo(personRepository.save(entity));
		return vo;
	}
	
}
