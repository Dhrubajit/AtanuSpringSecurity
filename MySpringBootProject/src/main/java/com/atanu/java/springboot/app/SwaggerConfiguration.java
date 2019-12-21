/**
 * 
 */
package com.atanu.java.springboot.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.AuthorizationCodeGrantBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.ResourceOwnerPasswordCredentialsGrant;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.service.TokenEndpoint;
import springfox.documentation.service.TokenRequestEndpoint;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Atanu Bhowmick
 *
 */

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	private static final String CLIENT_ID			= "client123";
	private static final String CLIENT_SECRET		= "secret";
	private static final String AUTH_SERVER			= "http://localhost:9090/oauth";
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.atanu.java.springboot.resource"))
				.paths(PathSelectors.regex("/.*"))
				.build()
				.securitySchemes(securityScheme())
				.securityContexts(securityContext())
				.apiInfo(apiEndPointsInfo());
	}

	/**
	 * @return ApiInfo
	 */
	private ApiInfo apiEndPointsInfo() {
		return new ApiInfoBuilder().title("Spring Boot REST API").description("Data Svc Springboot REST API")
				.contact(new Contact("Atanu Bhowmick", "http://localhost:8080", "mail2atanu007@gmail.com"))
				.license("Apache 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").version("1.0.0")
				.build();
	}
	
	@Bean
	public SecurityConfiguration security() {
	    return SecurityConfigurationBuilder.builder()
	        .clientId(CLIENT_ID)
	        .clientSecret(CLIENT_SECRET)
	        .scopeSeparator(" ")
	        .useBasicAuthenticationWithAccessCodeGrant(true)
	        .build();
	}
	
	private List<SecurityScheme> securityScheme() {
		
		List<SecurityScheme> schemes = new ArrayList<>();
		
		GrantType grantTypeClientCredentials = new AuthorizationCodeGrantBuilder()
		        .tokenEndpoint(new TokenEndpoint(AUTH_SERVER + "/token", "oauthtoken"))
		        .tokenRequestEndpoint(
		          new TokenRequestEndpoint(AUTH_SERVER + "/authorize", CLIENT_ID, CLIENT_SECRET))
		        .build();
		SecurityScheme oauthClientCredentials = new OAuthBuilder().name("spring_oauth2")
		        .grantTypes(Arrays.asList(grantTypeClientCredentials))
		        .scopes(Arrays.asList(scopes()))
		        .build();
		
		schemes.add(oauthClientCredentials);
		
		GrantType grantTypePassword = new ResourceOwnerPasswordCredentialsGrant(AUTH_SERVER + "/token");
		SecurityScheme oauth = new OAuthBuilder().name("oauth2")
		        .grantTypes(Arrays.asList(grantTypePassword))
		        .scopes(Arrays.asList(scopes()))
		        .build();
		//SecurityScheme oauth = new OAuth("oauth2", Arrays.asList(scopes()), Arrays.asList(grantType));
	    schemes.add(oauth);
		
	    ApiKey apiKey = new ApiKey("JWT", HttpHeaders.AUTHORIZATION, "header");
	    schemes.add(apiKey);
	    
	    return schemes;
	}
	
	/**
	 * @return AuthorizationScope[]
	 */
	private AuthorizationScope[] scopes() {
		AuthorizationScope[] scopes = { 
				new AuthorizationScope("read", "For read operations"),
				new AuthorizationScope("write", "For write operations") };
		return scopes;
	}
	
	/**
	 * @return List of SecurityContext
	 */
	private List<SecurityContext> securityContext() {
		List<SecurityContext> contexts = new ArrayList<>();
		List<SecurityReference> references = new ArrayList<>();
		SecurityReference jwt = new SecurityReference("JWT", scopes());
		SecurityReference oauth2 = new SecurityReference("oauth2", scopes());
		SecurityReference springOauth2 = new SecurityReference("spring_oauth2", scopes());
		references.add(jwt);
		references.add(oauth2);
		references.add(springOauth2);
		SecurityContext securityContext = SecurityContext.builder()
				.securityReferences(references)
				.forPaths(PathSelectors.any())
				.build();
		contexts.add(securityContext);
		return contexts;
	}
}
