package com.example.beneficiario.model;

import java.util.Date;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Beneficiario {
	
	@Id @GeneratedValue 
	private Long id;
	
	private String nomeBeneficiario;
	
	private Date dataNascimento;
	
	private String sexo;
	
	private String mensagem;
	
	public Beneficiario(String nomeBeneficiario, Date dataNascimento, String sexo, String mensagem) {
		super();
		this.nomeBeneficiario = nomeBeneficiario;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.mensagem = mensagem;
	}

	public Optional<Long> getId() {
		return Optional.ofNullable(this.id);
	}

}
