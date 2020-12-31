package com.immfly.immflychallenge.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("LOCATION")
@Entity
@Table(name = "LOCATION", catalog = "immflydb")
public class Location implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 7750174970427220740L;

	@Id
	@Column(name = "ID")
	private String id;
	
	@Column(name = "CITY")
	private String city;

	@Column(name = "ALTERNATE_IDENT")
	private String alternateIdent;
	
	@Column(name = "AIRPORT_NAME")
	private String airportName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAlternateIdent() {
		return alternateIdent;
	}

	public void setAlternateIdent(String alternateIdent) {
		this.alternateIdent = alternateIdent;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}



}
