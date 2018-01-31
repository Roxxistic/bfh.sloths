package ch.bfh.sloths.yellowpages.partnercontactservice.clients;

import ch.bfh.sloths.yellowpages.partnercontactservice.fallbacks.ContactClientFallback;
import ch.bfh.sloths.yellowpages.partnercontactservice.models.Address;
import ch.bfh.sloths.yellowpages.partnercontactservice.models.Email;
import ch.bfh.sloths.yellowpages.partnercontactservice.models.Phone;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "contact-service", fallback = ContactClientFallback.class)
public interface ContactClient {

    @RequestMapping(method = RequestMethod.GET, value = "/addresses")
    Resources<Address> getAddresses();

    @RequestMapping(method = RequestMethod.GET, value = "/addresses/search/partner")
    Resources<Address> getAddressesForPartner(@RequestParam("partnerId") String partnerId);

    @RequestMapping(method = RequestMethod.GET, value = "/emails")
    Resources<Email> getEmails();

    @RequestMapping(method = RequestMethod.GET, value = "/emails/search/partner")
    Resources<Email> getEmailsForPartner(@RequestParam("partnerId") String partnerId);

    @RequestMapping(method = RequestMethod.GET, value = "/phones")
    Resources<Phone> getPhones();

    @RequestMapping(method = RequestMethod.GET, value = "/phones/search/partner")
    Resources<Phone> getPhonesForPartner(@RequestParam("partnerId") String partnerId);
}

