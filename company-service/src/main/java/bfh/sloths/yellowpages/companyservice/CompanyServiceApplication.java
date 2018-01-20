package bfh.sloths.yellowpages.companyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@SpringBootApplication
@EnableEurekaClient
public class CompanyServiceApplication extends RepositoryRestConfigurerAdapter {

	public static void main(String[] args) {
	    SpringApplication.run(CompanyServiceApplication.class, args);
	}

	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config){
	    config.exposeIdsFor(Company.class);
    }
}
