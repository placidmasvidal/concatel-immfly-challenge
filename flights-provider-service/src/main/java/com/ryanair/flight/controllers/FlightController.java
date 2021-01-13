package com.ryanair.flight.controllers;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ryanair.flight.dtos.RyanairFlightDto;
import com.ryanair.flight.services.IFlightProviderService;

@RestController
public class FlightController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);
		
	private IFlightProviderService flightProviderService;
	
	@Autowired
	private AmqpTemplate rabbitTemplate;

	@Value("${jsa.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${jsa.rabbitmq.routingkey}")
	private String routingKey;
	
	@Autowired
	public FlightController(IFlightProviderService flightProviderService) {
		super();
		this.flightProviderService = flightProviderService;
	}
	
	@RequestMapping(value="/v1/flight-information-tail/", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<RyanairFlightDto> retrieveFlights() throws IOException {
    	return flightProviderService.retrieveFlights();
	}
	
 /*   @GetMapping("/v1/flight-information-tail/")
    public GenericResponse<List<RyanairFlightDto>> retrieveFlights() throws IOException {
    	return new GenericResponseBuilder<List<RyanairFlightDto>>(flightProviderService.retrieveFlights()).build();
    }
*/

	@RequestMapping("/v1/flights-to-queue/")
	public @ResponseBody void sentFlightsToQueue() throws IOException {
		produce(flightProviderService.retrieveFlights());
	}
	
	private void produce(List<RyanairFlightDto> flights){
		rabbitTemplate.convertAndSend(exchange, routingKey, flights);
		System.out.println("Send msg = " + flights);
	}
	
	
}
