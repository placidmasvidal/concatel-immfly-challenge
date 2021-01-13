package com.immfly.immflychallenge.services.clients;

public interface IFlightsClient {

	void getFlights();
	
	void getFlightsFromQueue(String ident);
	
}
