package bfh.sloths.yellowpages.contactdataservice.Repositories;

import bfh.sloths.yellowpages.contactdataservice.Models.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface AddressRepository extends CrudRepository<Address, String> {

    List<Address> findByPartnerId(@Param("partnerId") String partnerId);
}

