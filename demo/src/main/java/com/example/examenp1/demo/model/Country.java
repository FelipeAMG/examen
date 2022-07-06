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
@Table(name = "country")
public class Country {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@Column(name="id_airport")
	private long id_airport;
	
	@Column(name="c_name")
	private String name;
	
	@OneToOne(mappedBy = "country")
	private Employee employee;
	
	@OneToMany
	@JoinColumn(name="id_airport", insertable=false, updatable=false)
	private List<Airport> airport;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId_airport() {
		return id_airport;
	}

	public void setId_airport(long id_airport) {
		this.id_airport = id_airport;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
