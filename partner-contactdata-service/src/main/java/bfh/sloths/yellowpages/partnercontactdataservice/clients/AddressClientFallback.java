package bfh.sloths.yellowpages.partnercontactdataservice.clients;

import bfh.sloths.yellowpages.partnercontactdataservice.models.Address;
import bfh.sloths.yellowpages.partnercontactdataservice.models.Partner;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddressClientFallback implements AddressClient {

    @Override
    public Resources<Address> getAddresses() {
        return createDummyAddresses();
    }

    @Override
    public Resources<Address> getAddressesForPartner(String partnerId) {
        return createDummyAddresses();
    }

    private Resources<Address> createDummyAddresses(){
        List<Address> addresses = new ArrayList<>();
        Address address = new Address();
        address.setId("DUMMY");
        address.setStreet("DUMMY");
        address.setHouseNumber("DUMMY");
        address.setZip("DUMMY");
        address.setPlace("DUMMY");
        address.setPartnerId("DUMMY");
        addresses.add(address);
        return new Resources<>(addresses);
    }
}

