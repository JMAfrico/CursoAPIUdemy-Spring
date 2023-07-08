package br.com.JMCursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.JMCursos.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
