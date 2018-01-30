package ch.bfh.sloths.yellowpages.contactservice.repositories;

import ch.bfh.sloths.yellowpages.contactservice.models.Phone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PhoneRepository extends CrudRepository<Phone, String> {
}

