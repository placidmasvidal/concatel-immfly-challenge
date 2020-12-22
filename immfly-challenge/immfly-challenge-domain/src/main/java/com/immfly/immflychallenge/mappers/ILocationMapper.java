package com.immfly.immflychallenge.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.immfly.immflychallenge.dtos.LocationDto;
import com.immfly.immflychallenge.entities.Location;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ILocationMapper {
	
	LocationDto mapToDto(Location location);	
	Location mapFromDto(LocationDto locationDto);
	
	List<LocationDto> mapToDtoList(List<Location> values);
	List<Location> mapFromDtoList(List<LocationDto> values);	
	
}