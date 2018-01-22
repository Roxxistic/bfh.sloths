package bfh.sloths.yellowpages.partnercontactdataservice.clients;

import bfh.sloths.yellowpages.partnercontactdataservice.models.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "partner-service", fallback = PartnerClientFallback.class)
public interface PartnerClient {
    @RequestMapping(method = RequestMethod.GET, value = "/persons")
    Resources<Person> getPersons();

    @RequestMapping(method = RequestMethod.GET, value = "/persons/{id}")
    Resources<Person> getPerson(@PathVariable("id") String id);
}
