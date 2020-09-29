package com.example.hateoas.person;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "people")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String firstName;

	private String secondName;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDateTime dateOfBirth;

	private String profession;

	private int salary;
	
	public Person() {}
	
	public Person(final Person person) {
		this.firstName = person.getFirstName();
		this.secondName = person.getSecondName();
		this.dateOfBirth = person.getDateOfBirth();
		this.profession = person.getProfession();
		this.salary = person.getSalary();
	}

	public Person(final Person person, final long id) {
		this.id = id;
		this.firstName = person.getFirstName();
		this.secondName = person.getSecondName();
		this.dateOfBirth = person.getDateOfBirth();
		this.profession = person.getProfession();
		this.salary = person.getSalary();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public LocalDateTime getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDateTime dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
}
