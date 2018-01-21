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
@RequestMapping("/crud/")
public class CrudController {

	@Autowired
	private DataService dataService;



	@GetMapping("pojos")
	public @ResponseBody List<CrudPOJO> getAllPOJOs() throws Exception {
		return dataService.getAllPOJOs();
	}
	@PostMapping("pojo")
	public ResponseEntity<String> addPOJOs(@RequestBody CrudPOJO crudPOJO) {

		dataService.addPOJO(crudPOJO);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	@PostMapping("pojos")
	public ResponseEntity<String> addPOJO(@RequestBody List<CrudPOJO> crudPOJOs) {

		for(CrudPOJO pojo:crudPOJOs)
		{
			dataService.addPOJO(pojo);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	@PutMapping("pojos")
	public ResponseEntity<String> updatePOJO(@RequestBody CrudPOJO crudPOJO) {

		dataService.updatePOJO(crudPOJO);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	@DeleteMapping("pojos")
	public ResponseEntity<String> deletePOJO(@RequestBody CrudPOJO crudPOJO) {

		dataService.deletePOJO(crudPOJO);
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("pojos/{id}")
	public @ResponseBody CrudPOJO getPOJO(@PathVariable("id") int id) throws Exception {
		return dataService.getPOJO(id);
	}
}
