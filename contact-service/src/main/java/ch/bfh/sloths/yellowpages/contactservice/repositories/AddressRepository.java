package ch.bfh.sloths.yellowpages.contactservice.repositories;

import ch.bfh.sloths.yellowpages.contactservice.models.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface AddressRepository extends CrudRepository<Address, String> {

    @RestResource(path = "partner")
    List<Address> findByPartnerId(@Param("partnerId") String partnerId);
}
