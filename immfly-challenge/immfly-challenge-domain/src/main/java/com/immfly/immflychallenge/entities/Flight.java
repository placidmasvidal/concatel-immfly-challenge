package com.immfly.immflychallenge.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("FLIGHT")
@Entity
@Table(name = "FLIGHT")
public class Flight implements Serializable{
	
	private static final long serialVersionUID = -123456789L;
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private String id;

	@Column(name="FA_FLIGHT_ID")
	private String faFlightID;
	
	@Column(name="AIRLINE")
	private String airline;
	
	@Column(name="AIRLINE_IATA")
	private String airline_iata;
	
	@Column(name="FLIGHT_NUMBER")
	private String flightNumber;
	
	@Column(name="TAIL_NUMBER")
	private String tailNumber;
	
	@Column(name="TYPE")
	private String type;
	
	@Column(name="CODESHARES")
	private String codeshares;
	
	@Column(name="BLOCKED")
	private Boolean isBlocked;
	
	@Column(name="DIVERTED")
	private Boolean isDiverted;
	
	@Column(name="CANCELLED")
	private Boolean isCancelled;
	
	@Column(name="ORIGIN")
	private Location origin;
	
	@Column(name="DESTINATION")
	private Location destination;

	public String getIdent() {
		return id;
	}

	public void setIdent(String ident) {
		this.id = ident;
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

	public Location getOrigin() {
		return origin;
	}

	public void setOrigin(Location origin) {
		this.origin = origin;
	}

	public Location getDestination() {
		return destination;
	}

	public void setDestination(Location destination) {
		this.destination = destination;
	}
    
    @Override
    public String toString() {
        return "Flight{" + "ident='" + id + '\'' + ", faFlightID='" + faFlightID + '\'' + ", airline=" + airline + ", airline_iata=" + airline_iata + 
        		", flightNumber=" + flightNumber +
        		", tailNumber=" + tailNumber +
        		", type=" + type +
        		", codeshares=" + codeshares +
        		", blocked=" + isBlocked +
        		", diverted=" + isDiverted +
        		", cancelled=" + isCancelled +
        		", origin=" + origin +
        		", destination=" + destination +
        		'}';
    }
    

}
