package com.immfly.immflychallenge.exceptions;

public class AircraftException extends Exception {

	private static final long serialVersionUID = 987654321L;

	public AircraftException(String errorMessage) {
       super(errorMessage);
   }
	
	public AircraftException(Throwable ex) {
	       super(ex);
	   }
}
