package com.ryanair.flight.services;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ryanair.flight.dtos.FlightDto;


@Service
public class FlightProviderServiceImpl implements IFlightProviderService{
 
 
	@Override
	public List<FlightDto> retrieveFlights() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
	TypeReference<List<FlightDto>> typeReference = new TypeReference<List<FlightDto>>(){};
	InputStream inputStream = TypeReference.class.getResourceAsStream("/flights.json");
	
	return mapper.readValue(inputStream,typeReference);
	}
}
