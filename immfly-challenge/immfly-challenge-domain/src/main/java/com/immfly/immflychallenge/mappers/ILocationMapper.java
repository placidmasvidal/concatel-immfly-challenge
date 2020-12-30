package com.immfly.immflychallenge.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import com.immfly.immflychallenge.dtos.LocationDto;
import com.immfly.immflychallenge.dtos.ryanair.dtos.RyanairLocationDto;
import com.immfly.immflychallenge.entities.Location;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ILocationMapper {
	
	LocationDto mapToDto(Location location);	
	Location mapFromDto(LocationDto locationDto);
	
	@Mappings ({
		@Mapping(source = "code", target = "id"),
		@Mapping(source = "alternate_ident", target = "alternateIdent"),
		@Mapping(source = "airport_name", target = "airportName")
	})
	LocationDto mapFromExternalDtoToDto(RyanairLocationDto ryanairLocationDto);
	List<LocationDto> mapFromExternalDtoListToDtoList(List<RyanairLocationDto> values);
	
	List<LocationDto> mapToDtoList(List<Location> values);
	List<Location> mapFromDtoList(List<LocationDto> values);	
	
}