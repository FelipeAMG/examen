package com.example.examenp1.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@Column(name="surname")
	private String surname;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="id_country")
	private long id_country;
	
	@Column(name="id_language")
	private long id_language;

	@OneToMany
	@JoinColumn(name="id_language", insertable=false, updatable=false)
	private List<Language> language;
	
	@OneToOne
	@JoinColumn(name = "id_country", insertable=false, updatable=false)
	private Country country;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public long getId_country() {
		return id_country;
	}

	public void setId_country(long id_country) {
		this.id_country = id_country;
	}

	public long getId_language() {
		return id_language;
	}

	public void setId_language(long id_language) {
		this.id_language = id_language;
	}	

}
