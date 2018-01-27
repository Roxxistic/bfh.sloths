package ch.bfh.sloths.yellowpages.partnerservice.repositories;

import ch.bfh.sloths.yellowpages.partnerservice.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PersonRepository extends CrudRepository<Person, String> {
}
