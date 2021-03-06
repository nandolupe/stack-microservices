package com.example.monitorserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@EnableAdminServer
@SpringBootApplication
public class MonitorServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonitorServerApplication.class, args);
	}

}
