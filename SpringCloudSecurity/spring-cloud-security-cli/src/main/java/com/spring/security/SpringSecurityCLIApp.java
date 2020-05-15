package com.spring.security;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

@SpringBootApplication
public class SpringSecurityCLIApp implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityCLIApp.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		System.out.println("cron job started");
		
		ClientCredentialsResourceDetails resourceDetails = new ClientCredentialsResourceDetails();
        resourceDetails.setAccessTokenUri("http://localhost:8082/authserver/oauth/token");
        resourceDetails.setClientId("pictjrkg");
        resourceDetails.setClientSecret("frangipani");
        resourceDetails.setGrantType("client_credentials");
        resourceDetails.setScope(Arrays.asList("read"));
        
        DefaultOAuth2ClientContext clientContext = new DefaultOAuth2ClientContext();
		
        OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resourceDetails, clientContext);
	
		String token =  restTemplate.getAccessToken().toString();//.getValue();
		
		System.out.println("Token: " + token);
		
		String s = restTemplate.getForObject("http://localhost:8081/services/tolldata", String.class);
		
		System.out.println("Result: " + s);
	}
	
	
}
