package com.skymicrosystems.chmapi.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

//@Entity
//@Table(name = "squad")
@Document(collection = "squads")
public class Squad {
	
	@Id 
	private String id;
	
	@NotNull(message = "Nome do squad invalido.")
	private String name;
	
	@NotNull(message = "TAG invalida.")
	private String tag;
	
	@JsonIgnore
	private Date dataInclusao;
	
	@JsonIgnore
	private Date dataAlteracao;
	
	private List<Player> membros;
	
	private Player proprietario;
	
	public Squad() {}

	public Squad(Squad squad) {
		super();
		this.name = squad.getName();
		this.tag = squad.getTag();
		this.dataInclusao = squad.getDataInclusao();
		this.dataAlteracao = squad.getDataAlteracao();
		this.membros = squad.getMembros();
		this.proprietario = squad.getProprietario();
	}
	
	public Squad(Squad squad, String id) {
		super();
		this.id = id;
		this.name = squad.getName();
		this.tag = squad.getTag();
		this.dataInclusao = squad.getDataInclusao();
		this.dataAlteracao = squad.getDataAlteracao();
		this.membros = squad.getMembros();
		this.proprietario = squad.getProprietario();
	}
	
	public Squad(String id, String name, String tag, Date dataInclusao, Date dataAlteracao, List<Player> membros, Player proprietario) {
		super();
		this.id = id;
		this.name = name;
		this.tag = tag;
		this.dataInclusao = dataInclusao;
		this.dataAlteracao = dataAlteracao;
		this.membros = membros;
		this.proprietario = proprietario;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}
	
	public List<Player> getMembros() {
		return membros;
	}

	public void setMembros(List<Player> membros) {
		this.membros = membros;
	}

	public Player getProprietario() {
		return proprietario;
	}

	public void setProprietario(Player proprietario) {
		this.proprietario = proprietario;
	}

	@Override
	public String toString() {
		ObjectMapper mapper = new ObjectMapper();

		String jsonString = "";
		try {
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			jsonString = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return jsonString;
	}
}
