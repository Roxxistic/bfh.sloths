package bfh.sloths.yellowpages.partnercontactdataservice.models;

import org.springframework.hateoas.ResourceSupport;

import java.util.Collection;

public class PartnerAddress extends ResourceSupport {
    private String partnerName;

    private Collection<Address> addresses;

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public Collection<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Collection<Address> addresses) {
        this.addresses = addresses;
    }
}

