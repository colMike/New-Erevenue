package com.revenue.revenueCollection;

import org.glassfish.jersey.jaxb.internal.XmlCollectionJaxbProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.ErrorPageFilter;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RevenueCollectionApplication  extends SpringBootServletInitializer {

	public RevenueCollectionApplication() {
		super();
		setRegisterErrorPageFilter(false); // <- this one
	}



	public static void main(String[] args) {
		SpringApplication.run(RevenueCollectionApplication.class, args);
	}

}
