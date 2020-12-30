package com.immfly.immflychallenge.services.clients;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.immfly.immflychallenge.dtos.FlightDto;
import com.immfly.immflychallenge.dtos.ryanair.dtos.RyanairFlightDto;
import com.immfly.immflychallenge.entities.Flight;
import com.immfly.immflychallenge.mappers.IFlightMapper;
import com.immfly.immflychallenge.repositories.FlightJpaRepository;

@Service
//@ConfigurationProperties(prefix = "immfly.flightsclient", ignoreUnknownFields = false)
public class RyanairFlightsClientImpl implements IFlightsClient{
	
	public final String FLIGHT_PATH_V1 = "/v1/flight-information-tail/";
//	@Value("${immfly.flightsclient.apiHost}")
	private String apiHost="http://localhost:9090";
	
	private final RestTemplate restTemplate;
	
	private FlightJpaRepository flightJpaRepository;
	
	private IFlightMapper flightMapper;
	
	@Autowired	
	public RyanairFlightsClientImpl(RestTemplateBuilder restTemplateBuilder,
			FlightJpaRepository flightJpaRepository,
			IFlightMapper flightMapper) {
        this.restTemplate = restTemplateBuilder.build();
        this.flightJpaRepository = flightJpaRepository;
        this.flightMapper = flightMapper;
    }
    
	@Override
    public void getFlights(){
    	ResponseEntity<List<RyanairFlightDto>> flightResponse =
    			restTemplate.exchange(apiHost + FLIGHT_PATH_V1, HttpMethod.GET, null, new ParameterizedTypeReference<List<RyanairFlightDto>>() {});
    	List<FlightDto> flightsDtos = flightMapper.mapFromExternalDtoListToDtoList(flightResponse.getBody());
    	List<Flight> flights = flightMapper.mapFromDtoList(flightsDtos);
    	flights.forEach(flight -> flightJpaRepository.save(flight));
    }
    
	public String getApiHost() {
		return apiHost;
	}

	public void setApiHost(String apiHost) {
		this.apiHost = apiHost;
	}
	
	

}
