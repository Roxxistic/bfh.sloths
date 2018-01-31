package ch.bfh.sloths.yellowpages.partnercontactservice.fallbacks;

import ch.bfh.sloths.yellowpages.partnercontactservice.clients.PartnerClient;
import ch.bfh.sloths.yellowpages.partnercontactservice.models.Company;
import ch.bfh.sloths.yellowpages.partnercontactservice.models.Person;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PartnerClientFallback implements PartnerClient {

    @Override
    public Resources<Person> getPersons() {
        List<Person> list = new ArrayList<>();
        list.add(createDummyPerson());
        return new Resources<>(list);
    }

    @Override
    public Resource<Person> getPerson(String id) {
        return new Resource<>(createDummyPerson());
    }

    @Override
    public Resources<Company> getCompanies(){
        List<Company> list = new ArrayList<>();
        list.add(createDummyCompany());
        return new Resources<>(list);
    }

    @Override
    public Resource<Company> getCompany(String id){
        return new Resource<>(createDummyCompany());
    }

    private Person createDummyPerson(){
        Person person = new Person();
        person.setId("DUMMY PERSON ID");
        person.setFirstname("DUMMY FIRST NAME");
        person.setLastname("DUMMY LAST NAME");
        return person;
    }

    private Company createDummyCompany(){
        Company company = new Company();
        company.setId("DUMMY COMPANY ID");
        company.setName("DUMMY COMPANY NAME");
        return company;
    }
}
