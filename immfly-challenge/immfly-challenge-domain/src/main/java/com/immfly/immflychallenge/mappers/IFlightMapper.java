package com.immfly.immflychallenge.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import com.immfly.immflychallenge.dtos.FlightDto;
import com.immfly.immflychallenge.entities.Flight;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = IAircraftMapper.class)
public interface IFlightMapper {
		
	@Mappings ({
		@Mapping(source = "departureTime", dateFormat = "yyyy-MM-dd HH:mm:ss", target = "departureTime"),
		@Mapping(source = "landingTime", dateFormat = "yyyy-MM-dd HH:mm:ss", target = "landingTime")
	})
	FlightDto mapToDto(Flight flight);	
	@Mappings ({
		@Mapping(source = "departureTime", dateFormat = "yyyy-MM-dd HH:mm:ss", target = "departureTime"),
		@Mapping(source = "landingTime", dateFormat = "yyyy-MM-dd HH:mm:ss", target = "landingTime")
	})
	Flight mapFromDto(FlightDto flightDto);
	
	List<FlightDto> mapToDtoList(List<Flight> values);
	List<Flight> mapFromDtoList(List<FlightDto> values);	
	
}