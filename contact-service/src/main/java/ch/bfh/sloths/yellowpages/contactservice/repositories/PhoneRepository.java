package ch.bfh.sloths.yellowpages.contactservice.repositories;

import ch.bfh.sloths.yellowpages.contactservice.models.Phone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface PhoneRepository extends CrudRepository<Phone, String> {
    @RestResource(path = "partner")
    List<Phone> findByPartnerId(@Param("partnerId") String partnerId);
}

