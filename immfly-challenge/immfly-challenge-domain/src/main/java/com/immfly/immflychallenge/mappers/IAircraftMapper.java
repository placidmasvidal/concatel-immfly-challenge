package com.immfly.immflychallenge.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.immfly.immflychallenge.dtos.AircraftDto;
import com.immfly.immflychallenge.entities.Aircraft;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = IFlightMapper.class)
public interface IAircraftMapper {

	AircraftDto mapToDto(Aircraft aircraft);

	Aircraft mapFromDto(AircraftDto aircraftDto);

	List<AircraftDto> mapToDtoList(List<Aircraft> values);

	List<Aircraft> mapFromDtoList(List<AircraftDto> values);	
}
