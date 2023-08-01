package br.com.JMCursos.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.JMCursos.data.vo.v2.PersonVOV2;
import br.com.JMCursos.models.Person;

@Service
public class PersonMapper {

   
   public PersonVOV2 convertEntityToVo(Person person) {
	   PersonVOV2 vo = new PersonVOV2();
	   vo.setId(person.getId());
	   vo.setFirstName(person.getFirstName());
	   vo.setLastName(person.getLastName());
	   vo.setAdress(person.getAdress());
	   vo.setGender(person.getGender());
	   vo.setBirthDay(new String());
	   return vo;
   }
   
   public Person convertVoToEntity(PersonVOV2 personvov2) {
	   Person entity = new Person();
	   entity.setId(personvov2.getId());
	   entity.setFirstName(personvov2.getFirstName());
	   entity.setLastName(personvov2.getLastName());
	   entity.setAdress(personvov2.getAdress());
	   entity.setGender(personvov2.getGender());
//	   entity.setBirthDay(new Date());
	   return entity;
   }
}
