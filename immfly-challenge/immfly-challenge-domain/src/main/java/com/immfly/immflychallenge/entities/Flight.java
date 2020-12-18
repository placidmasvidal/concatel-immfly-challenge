package com.immfly.immflychallenge.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FLIGHT")
public class Flight implements Serializable{
	
	private static final long serialVersionUID = -123456789L;
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long id;

	@Column(name="DEPARTURE_TIME")
	private Date departureTime;
	
	@Column(name="LANDING_TIME")
	private Date landingTime;
	
    @ManyToOne
    @JoinColumn(name = "AIRCRAFT_ID")
    private Aircraft aircraft;


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


	public Aircraft getAircraft() {
		return aircraft;
	}


	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}
    
    

}
