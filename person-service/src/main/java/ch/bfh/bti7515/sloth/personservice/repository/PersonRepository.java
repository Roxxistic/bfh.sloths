package ch.bfh.bti7515.sloth.personservice.repository;


import ch.bfh.bti7515.sloth.personservice.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PersonRepository extends CrudRepository<Person, String> {
}

