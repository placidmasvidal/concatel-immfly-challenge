package com.ryanair.flights.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LocationDto {

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
