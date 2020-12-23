package com.immfly.immflychallenge.services.clients;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.immfly.immflychallenge.dtos.FlightDto;
import com.immfly.immflychallenge.entities.Flight;
import com.immfly.immflychallenge.mappers.IFlightMapper;
import com.immfly.immflychallenge.repositories.FlightRepository;

@Component
@ConfigurationProperties(prefix = "immfly.flightsclient", ignoreUnknownFields = false)
public class RyanairFlightsClientImpl implements IFlightsClient{
	
	public final String FLIGHT_PATH_V1 = "/v1/flight-information-tail/";
	private String apiHost;
	
	private final RestTemplate restTemplate;
	
	private FlightRepository flightRepository;
	
	private IFlightMapper flightMapper;
	
	@Autowired	
	public RyanairFlightsClientImpl(RestTemplateBuilder restTemplateBuilder,
			FlightRepository flightRepository,
			IFlightMapper flightMapper) {
        this.restTemplate = restTemplateBuilder.build();
        this.flightRepository = flightRepository;
        this.flightMapper = flightMapper;
    }
    
	@Override
    public /*List<FlightDto>*/ void getFlights(){
    	ResponseEntity<FlightDto[]> response =
    			restTemplate.getForEntity(apiHost + FLIGHT_PATH_V1, FlightDto[].class);
    	List<Flight> flights = flightMapper.mapFromDtoList(Arrays.asList(response.getBody()));
    	flights.forEach(flight -> flightRepository.save(flight));
//        return Arrays.asList(response.getBody());
    }
    
	public String getApiHost() {
		return apiHost;
	}

	public void setApiHost(String apiHost) {
		this.apiHost = apiHost;
	}
	
	

}
