package com.example.beneficiario.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.beneficiario.model.Beneficiario;

@RestController
public class BeneficiarioController {
	
	@Autowired
	private Environment env;
	
	 @RequestMapping(value = "/buscar", method = RequestMethod.GET, produces = "application/json") 
	 
	 public Beneficiario buscarBeneficiario() { Beneficiario
		 beneficiario = new Beneficiario("Luiz Fernando Pereira", new Date(), "M", env.getProperty("teste.propriedade"));
		 
		 return beneficiario; 
	 }

}
