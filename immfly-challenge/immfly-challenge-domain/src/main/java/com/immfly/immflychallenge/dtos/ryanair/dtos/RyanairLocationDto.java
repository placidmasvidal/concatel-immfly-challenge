package com.immfly.immflychallenge.dtos.ryanair.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RyanairLocationDto {

	private String code;
	
	private String city;
	
	private String alternate_ident;
	
	private String airport_name;

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

	public String getAlternate_ident() {
		return alternate_ident;
	}

	public void setAlternate_ident(String alternate_ident) {
		this.alternate_ident = alternate_ident;
	}

	public String getAirport_name() {
		return airport_name;
	}

	public void setAirport_name(String airport_name) {
		this.airport_name = airport_name;
	}


}
