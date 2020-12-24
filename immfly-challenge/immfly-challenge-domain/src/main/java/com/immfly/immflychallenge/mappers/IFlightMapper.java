package com.immfly.immflychallenge.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.immfly.immflychallenge.dtos.FlightDto;
import com.immfly.immflychallenge.entities.Flight;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = 
ILocationMapper.class
)
public interface IFlightMapper {
	
	FlightDto mapToDto(Flight flight);	
	Flight mapFromDto(FlightDto flightDto);
	
	List<FlightDto> mapToDtoList(List<Flight> values);
	List<Flight> mapFromDtoList(List<FlightDto> values);	
	
}