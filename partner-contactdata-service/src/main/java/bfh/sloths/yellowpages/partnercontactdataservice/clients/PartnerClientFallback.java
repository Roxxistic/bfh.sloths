package bfh.sloths.yellowpages.partnercontactdataservice.clients;

import bfh.sloths.yellowpages.partnercontactdataservice.models.Partner;
import bfh.sloths.yellowpages.partnercontactdataservice.models.Person;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PartnerClientFallback implements PartnerClient {

    @Override
    public Resources<Person> getPersons() {
        return createDummyPerson();
    }

    @Override
    public Resources<Person> getPerson(String id) {
        return createDummyPerson();
    }

    private Resources<Person> createDummyPerson(){
        List<Person> persons = new ArrayList<>();
        Person person = new Person();
        person.setId("DUMMYID");
        person.setLastName("DUMMYLASTNAME");
        person.setFirstName("DUMMYFIRSTNAME");
        persons.add(person);
        return new Resources<>(persons);
    }
}