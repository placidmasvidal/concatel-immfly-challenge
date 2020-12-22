package com.immfly.immflychallenge.services.clients;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.immfly.immflychallenge.dtos.FlightDto;

@Component
@ConfigurationProperties(prefix = "immfly.flightsclient", ignoreUnknownFields = false)
public class RyanairFlightsClientImpl implements IFlightsClient{
	
	public final String FLIGHT_PATH_V1 = "/v1/flight-information-tail/";
	private String apiHost;
	
	private final RestTemplate restTemplate;
		
	public RyanairFlightsClientImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
    
	@Override
    public List<FlightDto> getFlights(){
    	ResponseEntity<FlightDto[]> response =
    			restTemplate.getForEntity(apiHost + FLIGHT_PATH_V1, FlightDto[].class);
        return Arrays.asList(response.getBody());
    }
    
	public String getApiHost() {
		return apiHost;
	}

	public void setApiHost(String apiHost) {
		this.apiHost = apiHost;
	}
	
	

}
