package com.spring.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;

@Configuration
public class AuthConfig extends AuthorizationServerConfigurerAdapter {
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		
		String password = new ServerConfig().passwordEncoder().encode("frangipani");
		
		clients.inMemory().withClient("pictjrkg").secret(password).authorizedGrantTypes("client_credentials")
        .scopes("read","test").authorities("CLIENT");
	}
}
