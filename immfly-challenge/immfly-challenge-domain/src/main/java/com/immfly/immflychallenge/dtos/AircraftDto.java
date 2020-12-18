package com.immfly.immflychallenge.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AircraftDto {
	
	private Long id;
	
	private int capacity;
	
    private List<FlightDto> flights;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<FlightDto> getFlights() {
		return flights;
	}

	public void setFlights(List<FlightDto> flights) {
		this.flights = flights;
	}

    
    
}
