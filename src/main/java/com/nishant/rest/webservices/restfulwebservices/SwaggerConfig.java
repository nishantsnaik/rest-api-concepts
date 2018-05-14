package com.nishant.rest.webservices.restfulwebservices;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.assertj.core.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.ImmutableList;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	public static final Contact DEFAULT_CONTACT = new Contact("Nishant Naik", "www.google.com", "nishantsnaik@gmail.com");
	  public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Awesome Api Documentation", "Awesome Api Documentation", "1.0", "urn:tos",
	          DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());
	
	public static final ImmutableList<String> DEFAULT_PRODUCES_AND_CONSUMES = ImmutableList.of("applicaion/json", "applicaion/xml");
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO).produces(new HashSet<String>(DEFAULT_PRODUCES_AND_CONSUMES)).consumes(new HashSet<String>(DEFAULT_PRODUCES_AND_CONSUMES));
	}

}
