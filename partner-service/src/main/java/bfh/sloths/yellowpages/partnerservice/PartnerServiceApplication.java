package bfh.sloths.yellowpages.partnerservice;

import bfh.sloths.yellowpages.partnerservice.Models.Company;
import bfh.sloths.yellowpages.partnerservice.Models.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@SpringBootApplication
@EnableEurekaClient
public class PartnerServiceApplication extends RepositoryRestConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(PartnerServiceApplication.class, args);
	}

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config){
        config.exposeIdsFor(Person.class);
        config.exposeIdsFor(Company.class);
    }
}
