package bfh.sloths.yellowpages.partnercontactdataservice.clients;

import bfh.sloths.yellowpages.partnercontactdataservice.models.Address;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "contactdata-service", fallback = AddressClientFallback.class)
public interface AddressClient {
    @RequestMapping(method = RequestMethod.GET, value = "/addresses")
    Resources<Address> getAddresses();

    @RequestMapping(method = RequestMethod.GET, value = "/addresses/search/partner")
    Resources<Address> getAddressesForPartner(@RequestParam("partnerId") String partnerId);
}



