package ch.bfh.sloths.yellowpages.partnercontactservice.fallbacks;

import ch.bfh.sloths.yellowpages.partnercontactservice.clients.ContactClient;
import ch.bfh.sloths.yellowpages.partnercontactservice.models.Address;
import ch.bfh.sloths.yellowpages.partnercontactservice.models.Email;
import ch.bfh.sloths.yellowpages.partnercontactservice.models.Phone;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContactClientFallback implements ContactClient {
    @Override
    public Resources<Address> getAddresses() {
        return createDummyAddressList();
    }

    @Override
    public Resources<Address> getAddressesForPartner(String partnerId) {
        return createDummyAddressList();
    }

    @Override
    public Resources<Email> getEmails() {
        return createDummyEmailList();
    }

    @Override
    public Resources<Email> getEmailsForPartner(String partnerId) {
        return createDummyEmailList();
    }

    @Override
    public Resources<Phone> getPhones() {
        return createDummyPhoneList();
    }

    @Override
    public Resources<Phone> getPhonesForPartner(String partnerId) {
        return createDummyPhoneList();
    }

    private Resources<Address> createDummyAddressList(){
        List<Address> list = new ArrayList<>();
        list.add(createDummyAddress());
        return new Resources<>(list);
    }

    private Resources<Email> createDummyEmailList(){
        List<Email> list = new ArrayList<>();
        list.add(createDummyEmail());
        return new Resources<>(list);
    }

    private Resources<Phone> createDummyPhoneList(){
        List<Phone> list = new ArrayList<>();
        list.add(createDummyPhone());
        return new Resources<>(list);
    }

    private Address createDummyAddress(){
        Address address = new Address();
        address.setId("DUMMY ADDRESS ID");
        address.setStreet("DUMMY ADDRESS STREET");
        address.setHousenumber("DUMMY ADDRESS HOUSE NUMBER");
        address.setZip("DUMMY ADDRESS ZIP");
        address.setPlace("DUMMY ADDRESS PLACE");
        address.setPartnerId("DUMMY PARTNER ID");
        return address;
    }

    private Phone createDummyPhone(){
        Phone phone = new Phone();
        phone.setId("DUMMY PHONE ID");
        phone.setNumber("DUMMY PHONE NUMBER");
        phone.setPartnerId("DUMMY PARTNER ID");
        return phone;
    }

    private Email createDummyEmail(){
        Email email = new Email();
        email.setId("DUMMY EMAIL ID");
        email.setEmailAddress("DUMMY EMAIL ADDRESS");
        email.setPartnerId("DUMMY PARTNER ID");
        return email;
    }
}

