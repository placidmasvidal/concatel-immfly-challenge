package com.immfly.immflychallenge.redis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Flight {
	
	private static final long serialVersionUID = 1603714798906422731L;
	
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
	
	private Location origin;
	
	private Location destination;
	
	
    
}
