package com.immfly.immflychallenge.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FlightDto {
	
	private String id;

	private String faFlightID;
	
	private String airline;
	
	private String airline_iata;
	
	private String flightNumber;
	
	private String tailNumber;
	
	private String type;
	
	private String codeshares;
	
	private Boolean isBlocked;
	
	private Boolean isDiverted;
	
	private Boolean isCancelled;
	
	private LocationDto origin;
	
	private LocationDto destination;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFaFlightID() {
		return faFlightID;
	}

	public void setFaFlightID(String faFlightID) {
		this.faFlightID = faFlightID;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getAirline_iata() {
		return airline_iata;
	}

	public void setAirline_iata(String airline_iata) {
		this.airline_iata = airline_iata;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getTailNumber() {
		return tailNumber;
	}

	public void setTailNumber(String tailNumber) {
		this.tailNumber = tailNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCodeshares() {
		return codeshares;
	}

	public void setCodeshares(String codeshares) {
		this.codeshares = codeshares;
	}

	public Boolean getIsBlocked() {
		return isBlocked;
	}

	public void setIsBlocked(Boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	public Boolean getIsDiverted() {
		return isDiverted;
	}

	public void setIsDiverted(Boolean isDiverted) {
		this.isDiverted = isDiverted;
	}

	public Boolean getIsCancelled() {
		return isCancelled;
	}

	public void setIsCancelled(Boolean isCancelled) {
		this.isCancelled = isCancelled;
	}

	public LocationDto getOrigin() {
		return origin;
	}

	public void setOrigin(LocationDto origin) {
		this.origin = origin;
	}

	public LocationDto getDestination() {
		return destination;
	}

	public void setDestination(LocationDto destination) {
		this.destination = destination;
	}
    
	
	
}
