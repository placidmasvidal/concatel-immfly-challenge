package com.immfly.immflychallenge.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AIRCRAFT")
public class Aircraft implements Serializable{
	
	private static final long serialVersionUID = 123456789L;
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long id;
	
	@Column(name="CAPACITY")
	private int capacity;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
	@JoinTable(name = "FLIGHT", joinColumns = @JoinColumn(name = "ID"), inverseJoinColumns = @JoinColumn(name = "AIRCRAFT_ID"))
    private List<Flight> flights;


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


	public List<Flight> getFlights() {
		return flights;
	}


	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

    
    
}
