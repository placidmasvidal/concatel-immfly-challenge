package com.immfly.immflychallenge.listener;

import java.util.Map;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.immfly.immflychallenge.entities.Flight;
import com.immfly.immflychallenge.repositories.FlightJpaRepository;

//import jdk.internal.org.jline.utils.Log;

//@Component
public class FlightMessageListener {

/*	private FlightJpaRepository flightJpaRepository;
	
	Logger logger = LogManager.getLogger(FlightMessageListener.class);
	
	@Autowired
	public FlightMessageListener (FlightJpaRepository flightJpaRepository) {this.flightJpaRepository = flightJpaRepository;}
	
	public void receiveMessage(Map<String, String> message) {
		Log.info("Received <" + message + ">");
		Optional<Flight> flight = flightJpaRepository.findById(message.get("id"));

		
		Log.info("Sent all...");
	}
*/	
}
