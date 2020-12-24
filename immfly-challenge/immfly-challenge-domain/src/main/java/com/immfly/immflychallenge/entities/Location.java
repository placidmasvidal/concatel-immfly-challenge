package com.immfly.immflychallenge.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("LOCATION")
@Entity
@Table(name = "LOCATION")
public class Location implements Serializable{
	
	private static final long serialVersionUID = -1234554321L;
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private String id;
	
	private String code;
	
	private String city;
	
	private String alternateIdent;
	
	private String airportName;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
