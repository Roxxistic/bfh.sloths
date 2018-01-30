package ch.bfh.sloths.yellowpages.partnercontactservice.fallbacks;

import ch.bfh.sloths.yellowpages.partnercontactservice.clients.PartnerClient;
import ch.bfh.sloths.yellowpages.partnercontactservice.models.Person;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Component;

@Component
public class PartnerClientFallback implements PartnerClient {

    @Override
    public Resources<Person> getPersons() {
        return null;
    }

    @Override
    public Resource<Person> getPerson(String id) {
        return null;
    }
}
