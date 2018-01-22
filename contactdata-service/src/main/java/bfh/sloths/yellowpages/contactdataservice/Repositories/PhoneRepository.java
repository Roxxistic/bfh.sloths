package bfh.sloths.yellowpages.contactdataservice.Repositories;

import bfh.sloths.yellowpages.contactdataservice.Models.Address;
import bfh.sloths.yellowpages.contactdataservice.Models.Phone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface PhoneRepository extends CrudRepository<Phone, String> {
    List<Phone> findByPartnerId(@Param("partnerId") String partnerId);
}
