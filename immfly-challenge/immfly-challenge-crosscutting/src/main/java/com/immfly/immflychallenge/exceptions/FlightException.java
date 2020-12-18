package com.immfly.immflychallenge.exceptions;

public class FlightException extends Exception {

	private static final long serialVersionUID = 987654321L;

	public FlightException(String errorMessage) {
       super(errorMessage);
   }
	
	public FlightException(Throwable ex) {
	       super(ex);
	   }
}
