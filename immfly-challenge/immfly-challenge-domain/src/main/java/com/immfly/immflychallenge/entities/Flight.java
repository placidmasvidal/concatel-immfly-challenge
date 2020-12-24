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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airline == null) ? 0 : airline.hashCode());
		result = prime * result + ((airline_iata == null) ? 0 : airline_iata.hashCode());
		result = prime * result + ((codeshares == null) ? 0 : codeshares.hashCode());
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + ((faFlightID == null) ? 0 : faFlightID.hashCode());
		result = prime * result + ((flightNumber == null) ? 0 : flightNumber.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isBlocked == null) ? 0 : isBlocked.hashCode());
		result = prime * result + ((isCancelled == null) ? 0 : isCancelled.hashCode());
		result = prime * result + ((isDiverted == null) ? 0 : isDiverted.hashCode());
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
		result = prime * result + ((tailNumber == null) ? 0 : tailNumber.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		if (airline == null) {
			if (other.airline != null)
				return false;
		} else if (!airline.equals(other.airline))
			return false;
		if (airline_iata == null) {
			if (other.airline_iata != null)
				return false;
		} else if (!airline_iata.equals(other.airline_iata))
			return false;
		if (codeshares == null) {
			if (other.codeshares != null)
				return false;
		} else if (!codeshares.equals(other.codeshares))
			return false;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (faFlightID == null) {
			if (other.faFlightID != null)
				return false;
		} else if (!faFlightID.equals(other.faFlightID))
			return false;
		if (flightNumber == null) {
			if (other.flightNumber != null)
				return false;
		} else if (!flightNumber.equals(other.flightNumber))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isBlocked == null) {
			if (other.isBlocked != null)
				return false;
		} else if (!isBlocked.equals(other.isBlocked))
			return false;
		if (isCancelled == null) {
			if (other.isCancelled != null)
				return false;
		} else if (!isCancelled.equals(other.isCancelled))
			return false;
		if (isDiverted == null) {
			if (other.isDiverted != null)
				return false;
		} else if (!isDiverted.equals(other.isDiverted))
			return false;
		if (origin == null) {
			if (other.origin != null)
				return false;
		} else if (!origin.equals(other.origin))
			return false;
		if (tailNumber == null) {
			if (other.tailNumber != null)
				return false;
		} else if (!tailNumber.equals(other.tailNumber))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
    public String toString() {
        return "Flight{" + "id='" + id + '\'' + ", faFlightID='" + faFlightID + '\'' + ", airline=" + airline + ", airline_iata=" + airline_iata + 
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
