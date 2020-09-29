package com.example.beneficiario.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "beneficiario")
public class Beneficiario {
	
	@Id @GeneratedValue 
	private Long id;
	
	private String nomeBeneficiario;
	
	private Date dataNascimento;
	
	private String sexo;
	
	private String mensagem;
	
	public Beneficiario() {}
	
	public Beneficiario(Beneficiario beneficiario) {
		super();
		this.nomeBeneficiario = beneficiario.getNomeBeneficiario();
		this.dataNascimento = beneficiario.getDataNascimento();
		this.sexo = beneficiario.getSexo();
		this.mensagem = beneficiario.getMensagem();
	}
	
	public Beneficiario(Beneficiario beneficiario, Long id) {
		super();
		this.id = id;
		this.nomeBeneficiario = beneficiario.getNomeBeneficiario();
		this.dataNascimento = beneficiario.getDataNascimento();
		this.sexo = beneficiario.getSexo();
		this.mensagem = beneficiario.getMensagem();
	}
	
	public Beneficiario(String nomeBeneficiario, Date dataNascimento, String sexo, String mensagem) {
		super();
		this.nomeBeneficiario = nomeBeneficiario;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.mensagem = mensagem;
	}

	public Long getId() {
		return id;
	}

	public String getNomeBeneficiario() {
		return nomeBeneficiario;
	}

	public void setNomeBeneficiario(String nomeBeneficiario) {
		this.nomeBeneficiario = nomeBeneficiario;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
