package ch.bfh.sloths.yellowpages.partnercontactservice.clients;

import ch.bfh.sloths.yellowpages.partnercontactservice.fallbacks.PartnerClientFallback;
import ch.bfh.sloths.yellowpages.partnercontactservice.models.Company;
import ch.bfh.sloths.yellowpages.partnercontactservice.models.Person;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@FeignClient(value = "partner-service", fallback = PartnerClientFallback.class)
public interface PartnerClient {

    @RequestMapping(method = GET, value = "/persons")
    Resources<Person> getPersons();

    @RequestMapping(method = GET, value = "/persons/{id}")
    Resource<Person> getPerson(@PathVariable("id") String id);

    @RequestMapping(method = GET, value = "/companies")
    Resources<Company> getCompanies();

    @RequestMapping(method = GET, value = "/companies/{id}")
    Resource<Company> getCompany(@PathVariable("id") String id);
}
