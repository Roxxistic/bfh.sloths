package ch.bfh.sloths.yellowpages.partnercontactservice.controllers;

import ch.bfh.sloths.yellowpages.partnercontactservice.clients.ContactClient;
import ch.bfh.sloths.yellowpages.partnercontactservice.clients.PartnerClient;
import ch.bfh.sloths.yellowpages.partnercontactservice.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.rest.webmvc.RepositoryLinksResource;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.mvc.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class PartnerContactController implements ResourceProcessor<RepositoryLinksResource> {

    @Qualifier("partner-service")
    @Autowired
    private PartnerClient partnerClient;

    @Qualifier("contact-service")
    @Autowired
    private ContactClient contactClient;

    @RequestMapping(value = "/person/{id}", method = GET, produces = "application/hal+jason")
    @ResponseBody
    public Resource<PersonContact> getContactInfoForPerson(@PathVariable("id") String id){
        Person person = partnerClient.getPerson(id).getContent();
        PersonContact personContact = getPersonContact(person);
        return new Resource<>(personContact);
    }

    @RequestMapping(value = "/person", method = GET, produces = "application/hal+json")
    @ResponseBody
    public Resources<PersonContact> getContactInfoForPersons(){
        List<PersonContact> personContactList = new ArrayList<>();
        Resources<Person> persons = partnerClient.getPersons();

        for(Person person : persons){
            PersonContact personContact = getPersonContact(person);
            personContact.add(ControllerLinkBuilder.linkTo(methodOn(PartnerContactController.class).getContactInfoForPerson(person.getId())).withSelfRel());
            personContact.add(ControllerLinkBuilder.linkTo(methodOn(PartnerContactController.class).getContactInfoForPerson(person.getId())).withRel("partnerContact"));
            personContactList.add(personContact);
        }
        return new Resources<>(personContactList);
    }

    private PersonContact getPersonContact(Person person){
        PersonContact personContact = new PersonContact();
        personContact.setFirstname(person.getFirstname());
        personContact.setLastname(person.getLastname());
        personContact.setAddresses(contactClient.getAddressesForPartner(person.getId()).getContent());
        personContact.setEmails(contactClient.getEmailsForPartner(person.getId()).getContent());
        personContact.setPhones(contactClient.getPhonesForPartner(person.getId()).getContent());
        return personContact;
    }

    @RequestMapping(value = "/company/{id}", method = GET, produces = "application/hal+jason")
    @ResponseBody
    public Resource<CompanyContact> getContactInfoForCompany(@PathVariable("id") String id){
        Company company = partnerClient.getCompany(id).getContent();
        CompanyContact companyContact = getCompanyContact(company);
        return new Resource<>(companyContact);
    }

    @RequestMapping(value = "/company", method = GET, produces = "application/hal+json")
    @ResponseBody
    public Resources<CompanyContact> getContactInfoForCompanies(){
        List<CompanyContact> list = new ArrayList<>();
        Resources<Company> companies = partnerClient.getCompanies();

        for(Company c : companies){
            CompanyContact companyContact = getCompanyContact(c);
            companyContact.add(ControllerLinkBuilder.linkTo(methodOn(PartnerContactController.class).getContactInfoForCompany(c.getId())).withSelfRel());
            companyContact.add(ControllerLinkBuilder.linkTo(methodOn(PartnerContactController.class).getContactInfoForCompany(c.getId())).withRel("partnerContact"));
            list.add(companyContact);
        }
        return new Resources<>(list);
    }

    private CompanyContact getCompanyContact(Company company){
        CompanyContact companyContact = new CompanyContact();
        companyContact.setName(company.getName());
        companyContact.setAddresses(contactClient.getAddressesForPartner(company.getId()).getContent());
        companyContact.setEmails(contactClient.getEmailsForPartner(company.getId()).getContent());
        companyContact.setPhones(contactClient.getPhonesForPartner(company.getId()).getContent());
        return companyContact;
    }

    @Override
    public RepositoryLinksResource process(RepositoryLinksResource repositoryLinksResource) {
        repositoryLinksResource.add(ControllerLinkBuilder.linkTo(methodOn(PartnerContactController.class).getContactInfoForPersons()).withRel("personContact"));
        repositoryLinksResource.add(ControllerLinkBuilder.linkTo(methodOn(PartnerContactController.class).getContactInfoForCompanies()).withRel("personContact"));
        return repositoryLinksResource;
    }
}
