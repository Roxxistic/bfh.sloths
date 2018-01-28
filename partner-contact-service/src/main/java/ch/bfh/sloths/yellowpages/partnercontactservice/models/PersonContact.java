package ch.bfh.sloths.yellowpages.partnercontactservice.models;

import org.springframework.hateoas.ResourceSupport;

import java.util.Collection;

public class PersonContact extends ResourceSupport {

    private String lastName;
    private String firstName;
    private Collection<Address> addresses;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Collection<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Collection<Address> addresses) {
        this.addresses = addresses;
    }
}
