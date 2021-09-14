package com.example.camel;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.example.camel")
public class CamelTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamelTestApplication.class, args);
	}
	
	@Value("${baeldung.api.path}")
	String contextPath;

	@Bean
	ServletRegistrationBean servletRegistrationBean() {
	    ServletRegistrationBean servlet = new ServletRegistrationBean
	      (new CamelHttpTransportServlet(), contextPath+"/*");
	    servlet.setName("CamelServlet");
	    return servlet;
	}
	
}
