package com.cine.msvc_eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication(exclude = { 
    org.springframework.cloud.client.discovery.composite.CompositeDiscoveryClientAutoConfiguration.class 
})

@EnableEurekaServer
public class MsvcEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcEurekaApplication.class, args);
	}

}
