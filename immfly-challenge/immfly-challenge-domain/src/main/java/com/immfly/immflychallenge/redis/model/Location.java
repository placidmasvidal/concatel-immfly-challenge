package com.immfly.immflychallenge.redis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Location {
	
	private String id;

	private String code;
	
	private String city;
	
	private String alternateIdent;
	
	private String airportName;

	
	
}
