package com.ryanair.flight.services;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ryanair.flight.dtos.RyanairFlightDto;


@Service
public class FlightProviderServiceImpl implements IFlightProviderService{
 
 
	@Override
	public List<RyanairFlightDto> retrieveFlights() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
	TypeReference<List<RyanairFlightDto>> typeReference = new TypeReference<List<RyanairFlightDto>>(){};
	InputStream inputStream = TypeReference.class.getResourceAsStream("/flights.json");
	
	return mapper.readValue(inputStream,typeReference);
	}
}
