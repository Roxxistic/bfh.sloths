package bfh.sloths.yellowpages.partnercontactdataservice.controllers;

import bfh.sloths.yellowpages.partnercontactdataservice.clients.AddressClient;
import bfh.sloths.yellowpages.partnercontactdataservice.clients.PartnerClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryLinksResource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PartnerContactdataController implements ResourceProcessor<RepositoryLinksResource> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PartnerContactdataController.class);

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private PartnerClient partnerClient;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private AddressClient addressClient;

    @Override
    public RepositoryLinksResource process(RepositoryLinksResource repositoryLinksResource) {
        return null;
    }
}
