package bfh.sloths.yellowpages.contactdataservice.Repositories;

import bfh.sloths.yellowpages.contactdataservice.Models.Email;
import org.springframework.data.repository.CrudRepository;

public interface EmailRepository extends CrudRepository<Email, String> {

}
