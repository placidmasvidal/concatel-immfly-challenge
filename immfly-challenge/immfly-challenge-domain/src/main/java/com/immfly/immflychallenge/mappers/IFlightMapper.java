package com.immfly.immflychallenge.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import com.immfly.immflychallenge.dtos.FlightDto;
import com.immfly.immflychallenge.dtos.ryanair.dtos.RyanairFlightDto;
import com.immfly.immflychallenge.entities.Flight;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = 
ILocationMapper.class
)
public interface IFlightMapper {
	
	FlightDto mapToDto(Flight flight);	
	Flight mapFromDto(FlightDto flightDto);

	@Mappings ({
		@Mapping(source = "ident", target = "id"),
		@Mapping(source = "airline_iata", target = "airlineIata"),
		@Mapping(source = "blocked", target = "isBlocked"),
		@Mapping(source = "diverted", target = "isDiverted"),
		@Mapping(source = "cancelled", target = "isCancelled"),
	})
	FlightDto mapFromExternalDtoToDto(RyanairFlightDto ryanairFlightDto);
	List<FlightDto> mapFromExternalDtoListToDtoList(List<RyanairFlightDto> values);
	
	List<FlightDto> mapToDtoList(List<Flight> values);
	List<Flight> mapFromDtoList(List<FlightDto> values);	
	
}