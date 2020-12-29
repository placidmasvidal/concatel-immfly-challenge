package com.immfly.immflychallenge.services.clients;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.immfly.immflychallenge.dtos.FlightDto;
import com.immfly.immflychallenge.entities.Flight;
import com.immfly.immflychallenge.mappers.IFlightMapper;
import com.immfly.immflychallenge.repositories.FlightJpaRepository;

@Service
//@ConfigurationProperties(prefix = "immfly.flightsclient", ignoreUnknownFields = false)
public class RyanairFlightsClientImpl implements IFlightsClient{
	
	public final String FLIGHT_PATH_V1 = "http://localhost:9090/v1/flight-information-tail/";
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
    public /*List<FlightDto>*/ void getFlights(){
    	ResponseEntity<FlightDto[]> response =
    			restTemplate.getForEntity(apiHost + FLIGHT_PATH_V1, FlightDto[].class);
    	List<Flight> flights = flightMapper.mapFromDtoList(Arrays.asList(response.getBody()));
    	flights.forEach(flight -> flightJpaRepository.save(flight));
//        return Arrays.asList(response.getBody());
    }
    
	public String getApiHost() {
		return apiHost;
	}

	public void setApiHost(String apiHost) {
		this.apiHost = apiHost;
	}
	
	

}
