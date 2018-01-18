package org.ajb.services.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class DataService {
	
	@Autowired
	private DataRepository dataRepository;


public List<CrudPOJO> getAllHospitals(){

    List<CrudPOJO> hospitalList= new ArrayList<CrudPOJO>();

    dataRepository.findAll().forEach(hospitalList::add);

    return hospitalList;

}

public CrudPOJO getHospital(int id){
	return dataRepository.findOne(id);
}

public void addHospital(CrudPOJO crudPOJO){
	dataRepository.save(crudPOJO);
}

public void updateHospital(CrudPOJO crudPOJO){
		dataRepository.save(crudPOJO);
	}
public void deleteHospital(CrudPOJO crudPOJO) {
	dataRepository.delete(crudPOJO);
}


}
