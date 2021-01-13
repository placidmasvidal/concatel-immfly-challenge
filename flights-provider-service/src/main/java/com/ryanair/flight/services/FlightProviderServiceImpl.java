package com.ryanair.flight.services;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ryanair.flight.amqp.FlightsQueueSender;
import com.ryanair.flight.dtos.RyanairFlightDto;


@Service
public class FlightProviderServiceImpl implements IFlightProviderService{
 
	Logger logger = LogManager.getLogger(FlightProviderServiceImpl.class);
 
	@Autowired
	private FlightsQueueSender flightsQueueSender;
	
	@Override
	public List<RyanairFlightDto> retrieveFlights() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
	TypeReference<List<RyanairFlightDto>> typeReference = new TypeReference<List<RyanairFlightDto>>(){};
	InputStream inputStream = TypeReference.class.getResourceAsStream("/flights.json");
	
	mapper.readValue(inputStream, typeReference).forEach(flight -> sendFlightMessage(flight.getIdent()));
	
	return mapper.readValue(inputStream,typeReference);
	}

	@Override
	public void sendFlightMessage(String ident) {
//		Map<String, String> actionmap = new HashMap<>();
//		actionmap.put("ident", ident);
		logger.info("Sending the index request through queue message");		
//		rabbitTemplate.convertAndSend(FlightsProviderServiceApplication.SFG_MESSAGE_QUEUE, actionmap);
		
		flightsQueueSender.send(ident);
	}
	
}
