package bfh.sloths.yellowpages.partnerservice.Repositories;

import bfh.sloths.yellowpages.partnerservice.Models.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, String> {

}

