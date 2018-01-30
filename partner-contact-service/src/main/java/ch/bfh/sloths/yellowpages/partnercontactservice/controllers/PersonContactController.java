package ch.bfh.sloths.yellowpages.partnercontactservice.controllers;

import ch.bfh.sloths.yellowpages.partnercontactservice.clients.ContactClient;
import ch.bfh.sloths.yellowpages.partnercontactservice.clients.PartnerClient;
import ch.bfh.sloths.yellowpages.partnercontactservice.models.Address;
import ch.bfh.sloths.yellowpages.partnercontactservice.models.Person;
import ch.bfh.sloths.yellowpages.partnercontactservice.models.PersonContact;
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
public class PersonContactController implements ResourceProcessor<RepositoryLinksResource> {

    @Autowired
    private PartnerClient partnerClient;

    @Autowired
    private ContactClient contactClient;

    @RequestMapping(value = "/personContact/{id}", method = GET, produces = "application/hal+jason")
    public Resource<PersonContact> getPersonContact(@PathVariable("id") String id){
        Person person = partnerClient.getPerson(id).getContent();
        Collection<Address> addresses = contactClient.getAddressesForPerson(person.getId()).getContent();
        PersonContact personContact = new PersonContact();
        personContact.setFirstname(person.getFirstname());
        personContact.setLastname(person.getLastname());
        personContact.setAddresses(addresses);
        return new Resource<>(personContact);
    }

    @RequestMapping(value = "/personContact", method = GET, produces = "application/hal+json")
    public Resources<PersonContact> getPersonContacts(){
        List<PersonContact> personContactList = new ArrayList<>();
        Resources<Person> persons = partnerClient.getPersons();

        for(Person person : persons){
            PersonContact personContact = new PersonContact();
            personContact.add(ControllerLinkBuilder.linkTo(methodOn(PersonContactController.class).getPersonContact(person.getId())).withSelfRel());
            personContact.add(ControllerLinkBuilder.linkTo(methodOn(PersonContactController.class).getPersonContact(person.getId())).withRel("personContact"));
            personContact.setFirstname(person.getFirstname());
            personContact.setLastname(person.getLastname());
            personContact.setAddresses(contactClient.getAddressesForPerson(person.getId()).getContent());
            personContactList.add(personContact);
        }
        return new Resources<>(personContactList);
    }

    @Override
    public RepositoryLinksResource process(RepositoryLinksResource repositoryLinksResource) {
        repositoryLinksResource.add(ControllerLinkBuilder.linkTo(methodOn(PersonContactController.class).getPersonContacts()).withRel("personContact"));
        return repositoryLinksResource;
    }
}
