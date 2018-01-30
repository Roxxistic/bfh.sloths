package ch.bfh.sloths.yellowpages.partnerservice.repositories;

import ch.bfh.sloths.yellowpages.partnerservice.models.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CompanyRepository extends CrudRepository<Company, String> {
}
