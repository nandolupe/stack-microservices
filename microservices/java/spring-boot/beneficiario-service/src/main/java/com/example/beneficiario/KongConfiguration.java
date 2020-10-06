package com.example.beneficiario;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Configuration
public class KongConfiguration {

	@Autowired
	private Environment env;

	@PostConstruct
	public void init() {

		if (env.getProperty("spring.kong.enabled").equals("true")) {
			RestTemplate restTemplate = new RestTemplate();
			
			try {
				
				ResponseEntity<String> serviceCreated = null; restTemplate.getForEntity(env.getProperty("spring.kong.url") + "/services/" + env.getProperty("spring.application.name"), 
						String.class);
				System.out.println("Service registred: " + serviceCreated);
				
			} catch (HttpClientErrorException.NotFound e) {
				ServiceObject stockAPI = new ServiceObject(env.getProperty("spring.application.name"),
						"http://" + env.getProperty("server.address") + ":" + env.getProperty("server.port"));
				HttpEntity<ServiceObject> apiEntity = new HttpEntity<>(stockAPI);
				ResponseEntity<String> addAPIResp = restTemplate.postForEntity(env.getProperty("spring.kong.url") + "/services",
						apiEntity, String.class);
		
				System.out.println(addAPIResp);
		
				RouteObject routeObject = new RouteObject();
				routeObject.setPaths(new String[] { "/" + env.getProperty("spring.application.name") });
		
				HttpEntity<RouteObject> apiEntityRoutes = new HttpEntity<>(routeObject);
				ResponseEntity<String> addAPIRespRoutes = restTemplate.postForEntity(env.getProperty("spring.kong.url")
						+ "/services/" + env.getProperty("spring.application.name") + "/routes", apiEntityRoutes, String.class);
				System.out.println(addAPIRespRoutes);
			}
			
		}
	}

}

class ServiceObject {
	private String name;
	private String url;

	public ServiceObject() {
	}

	public ServiceObject(String name, String url) {
		super();
		this.name = name;
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}

class RouteObject {
	private String[] paths;

	public String[] getPaths() {
		return paths;
	}

	public void setPaths(String[] paths) {
		this.paths = paths;
	}
}
