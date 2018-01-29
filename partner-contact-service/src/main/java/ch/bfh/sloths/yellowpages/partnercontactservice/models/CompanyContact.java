package ch.bfh.sloths.yellowpages.partnercontactservice.models;

import org.springframework.hateoas.ResourceSupport;

import java.util.Collection;

public class CompanyContact extends ResourceSupport {

    private String name;

    private Collection<Address> addresses;
    private Collection<Phone> phones;
    private Collection<Email> emails;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
