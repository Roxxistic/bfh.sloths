package ch.bfh.sloths.yellowpages.partnercontactservice.fallbacks;

import ch.bfh.sloths.yellowpages.partnercontactservice.clients.ContactClient;
import ch.bfh.sloths.yellowpages.partnercontactservice.models.Address;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContactClientFallback implements ContactClient {
    @Override
    public Resources<Address> getAddresses() {
        List<Address> list = new ArrayList<>();
        list.add(createDummy());
        return new Resources<>(list);
    }

    @Override
    public Resource<Address> getAddress(String id) {
        return new Resource<>(createDummy());
    }

    @Override
    public Resources<Address> getAddressesForPerson(String personId) {
        List<Address> list = new ArrayList<>();
        list.add(createDummy());
        return new Resources<>(list);
    }

    private Address createDummy(){
        Address address = new Address();
        address.setId("DUMMY ADDRESS ID");
        address.setStreet("DUMMY ADDRESS STREET");
        address.setHousenumber("DUMMY ADDRESS HOUSE NUMBER");
        address.setZip("DUMMY ADDRESS ZIP");
        address.setPlace("DUMMY ADDRESS PLACE");
        address.setPartnerId("DUMMY ADDRESS PARTNER ID");
        return address;
    }
}

