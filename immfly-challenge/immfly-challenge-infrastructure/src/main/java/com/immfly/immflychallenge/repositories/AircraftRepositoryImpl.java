package com.immfly.immflychallenge.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.immfly.immflychallenge.generic.CustomRepository;
import com.immfly.immflychallenge.generic.GenericRepository;

@Repository
public class AircraftRepositoryImpl implements CustomRepository {

    @Autowired
    private GenericRepository genericRepository;
	
	@Override
	public <T> List<T> getOne(List<T> params) {
		return genericRepository.getEntityFromPackage("PGK_AIRCRAFT.get_one_aircraft",params);
	}

    @Override
    public <T> List<T> getList(List<T> params){
        return genericRepository.getEntityFromPackage("PGK_AIRCRAFT.get_all_aircraft",params);
    }
    @Override
    public <T> void executeSP(List<T> params){
        String spName = params.get(0).toString();
        params.remove(0);
        genericRepository.executeStoredProcedure(spName, params);
    }
}
