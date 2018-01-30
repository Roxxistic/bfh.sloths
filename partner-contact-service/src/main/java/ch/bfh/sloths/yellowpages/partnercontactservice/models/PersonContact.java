package ch.bfh.sloths.yellowpages.partnercontactservice.models;

import org.springframework.hateoas.ResourceSupport;

import java.util.Collection;

public class PersonContact extends ResourceSupport {

    private String lastname;
    private String firstname;
    private Collection<Address> addresses;
    private Collection<Phone> phones;
    private Collection<Email> emails;

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Collection<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Collection<Address> addresses) {
        this.addresses = addresses;
    }

    public Collection<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Collection<Phone> phones) {
        this.phones = phones;
    }

    public Collection<Email> getEmails() {
        return emails;
    }

    public void setEmails(Collection<Email> emails) {
        this.emails = emails;
    }
}

