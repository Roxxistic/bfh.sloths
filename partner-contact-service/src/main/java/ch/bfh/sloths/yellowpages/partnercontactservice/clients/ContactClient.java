package ch.bfh.sloths.yellowpages.partnercontactservice.clients;

import ch.bfh.sloths.yellowpages.partnercontactservice.fallbacks.ContactClientFallback;
import ch.bfh.sloths.yellowpages.partnercontactservice.models.Address;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "contact-service", fallback = ContactClientFallback.class)
public interface ContactClient {

    @RequestMapping(method = RequestMethod.GET, value = "/addresses")
    Resources<Address> getAddresses();

    @RequestMapping(method = RequestMethod.GET, value = "/addresses/{id}")
    Resource<Address> getAddress(@PathVariable("id") String id);

    @RequestMapping(method = RequestMethod.GET, value = "/addresses/search/person")
    Resources<Address> getAddressesForPerson(@RequestParam("personId") String personId);
}

