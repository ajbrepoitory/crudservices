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


public List<CrudPOJO> getAllPOJOs(){

    List<CrudPOJO> POJOList= new ArrayList<CrudPOJO>();

    dataRepository.findAll().forEach(POJOList::add);

    return POJOList;

}

public CrudPOJO getPOJO(int id){
	return dataRepository.findOne(id);
}

public void addPOJO(CrudPOJO crudPOJO){
	dataRepository.save(crudPOJO);
}

public void updatePOJO(CrudPOJO crudPOJO){
		dataRepository.save(crudPOJO);
	}
public void deletePOJO(CrudPOJO crudPOJO) {
	dataRepository.delete(crudPOJO);
}


}
