package com.ryanair.flight.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RyanairFlightDto {
	
	private String ident;

	private String faFlightID;
	
	private String airline;
	
	private String airline_iata;
	
	private String flightNumber;
	
	private String tailNumber;
	
	private String type;
	
	private String codeshares;
	
	private boolean blocked;
	
	private boolean diverted;
	
	private boolean cancelled;
	
	private RyanairLocationDto origin;
	
	private RyanairLocationDto destination;

	public String getIdent() {
		return ident;
	}

	public void setIdent(String ident) {
		this.ident = ident;
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

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public boolean isDiverted() {
		return diverted;
	}

	public void setDiverted(boolean diverted) {
		this.diverted = diverted;
	}

	public boolean isCancelled() {
		return cancelled;
	}

	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

	public RyanairLocationDto getOrigin() {
		return origin;
	}

	public void setOrigin(RyanairLocationDto origin) {
		this.origin = origin;
	}

	public RyanairLocationDto getDestination() {
		return destination;
	}

	public void setDestination(RyanairLocationDto destination) {
		this.destination = destination;
	}


	
    
}
