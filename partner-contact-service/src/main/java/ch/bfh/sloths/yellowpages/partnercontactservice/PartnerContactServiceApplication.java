package ch.bfh.sloths.yellowpages.partnercontactservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class PartnerContactServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PartnerContactServiceApplication.class, args);
	}
}
