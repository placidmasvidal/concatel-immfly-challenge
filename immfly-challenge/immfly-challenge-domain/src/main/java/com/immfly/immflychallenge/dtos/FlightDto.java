package com.immfly.immflychallenge.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FlightDto {
	
	private Long id;

	private Date departureTime;
	
	private Date landingTime;
	
    private AircraftDto aircraft;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Date getLandingTime() {
		return landingTime;
	}

	public void setLandingTime(Date landingTime) {
		this.landingTime = landingTime;
	}

	public AircraftDto getAircraft() {
		return aircraft;
	}

	public void setAircraft(AircraftDto aircraft) {
		this.aircraft = aircraft;
	}
    
    
    
}
