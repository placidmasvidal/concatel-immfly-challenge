package com.ryanair.flight.providers.rabbitmq.dtos;

public class RyanairFlightInfo {
	
	private String airline_iata;
	
	private String flightNumber;
	
	private String tailNumber;

	public RyanairFlightInfo(String airline_iata, String flightNumber, String tailNumber) {
		super();
		this.airline_iata = airline_iata;
		this.flightNumber = flightNumber;
		this.tailNumber = tailNumber;
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
	
	
}
