package ch.bfh.sloths.yellowpages.contactservice.repositories;

import ch.bfh.sloths.yellowpages.contactservice.models.Email;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EmailRepository extends CrudRepository<Email, String> {
}
