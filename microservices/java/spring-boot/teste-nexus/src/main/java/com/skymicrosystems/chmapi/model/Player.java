package com.skymicrosystems.chmapi.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

//@Entity
//@Table(name = "player")
@Document(collection = "players")
public class Player {

	@Id
	private String id;

	@NotNull(message = "Primeiro nome invalido.")
	private String firstName;

	@NotNull(message = "Ultimo nome invalido.")
	private String lastName;

	@NotNull(message = "Gamertag invalida.")
	private String gamertag;

	@NotNull
	private String sexo;

	private Date dateOfBirth;

	@JsonIgnore
	private Date dataInclusao;

	@JsonIgnore
	private Date dataAlteracao;

	public Player() {
	}

	public Player(Player player) {
		super();
		this.firstName = player.getFirstName();
		this.lastName = player.getLastName();
		this.gamertag = player.getGamertag();
		this.sexo = player.getSexo();
		this.dateOfBirth = player.getDateOfBirth();
		this.dataInclusao = player.getDataInclusao();
		this.dataAlteracao = player.getDataAlteracao();
	}

	public Player(Player player, String id) {
		super();
		this.id = id;
		this.firstName = player.getFirstName();
		this.lastName = player.getLastName();
		this.gamertag = player.getGamertag();
		this.sexo = player.getSexo();
		this.dateOfBirth = player.getDateOfBirth();
		this.dataInclusao = player.getDataInclusao();
		this.dataAlteracao = player.getDataAlteracao();
	}

	public Player(String firstName, String lastName, String gamertag, String sexo, Date dateOfBirth, Date dataInclusao,
			Date dataAlteracao) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gamertag = gamertag;
		this.sexo = sexo;
		this.dateOfBirth = dateOfBirth;
		this.dataInclusao = dataInclusao;
		this.dataAlteracao = dataAlteracao;
	}

	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGamertag() {
		return gamertag;
	}

	public void setGamertag(String gamertag) {
		this.gamertag = gamertag;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	public void setId(String id) {
		this.id = id;
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
