package com.example.examenp1.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	
	@OneToOne
	@JoinColumn(name = "id_country")
	private Country country;
	
	@ManyToMany
	@JoinTable(name = "Employee_Language", joinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(name = "language_id", referencedColumnName = "id"))
	private List<Language> languages;
	

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
	
}
