package org.ajb.services.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/")
public class CrudController {

	@Autowired
	private DataService dataService;



	@GetMapping("hospitals")
	public @ResponseBody List<CrudPOJO> getAllHospitals() throws Exception {
		return dataService.getAllHospitals();
	}
	@PostMapping("hospitals")
	public ResponseEntity<String> addHospital(@RequestBody CrudPOJO crudPOJO) {

		dataService.addHospital(crudPOJO);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	@PutMapping("hospitals")
	public ResponseEntity<String> updateHospital(@RequestBody CrudPOJO crudPOJO) {

		dataService.updateHospital(crudPOJO);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	@DeleteMapping("hospitals")
	public ResponseEntity<String> deleteHospital(@RequestBody CrudPOJO crudPOJO) {

		dataService.deleteHospital(crudPOJO);
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("hospitals/{id}")
	public @ResponseBody CrudPOJO getHospital(@PathVariable("id") int id) throws Exception {
		return dataService.getHospital(id);
	}
}
