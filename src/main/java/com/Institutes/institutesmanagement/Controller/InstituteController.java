package com.Institutes.institutesmanagement.Controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.Institutes.institutesmanagement.Entity.Institute;
import com.Institutes.institutesmanagement.Service.InstituteService;

@RestController
@RequestMapping("api/institutes")
public class InstituteController {
	
	public InstituteController(InstituteService instituteService) {
		super();
		this.instituteService = instituteService;
	}

	@Autowired
	private InstituteService instituteService;
	
	//Build Register institute restApi
	@PostMapping
	public ResponseEntity<Institute> RegisterInstitute( @RequestBody Institute institiute){
		
		Institute savedinstitute=instituteService.registerInstitute(institiute);
		return new ResponseEntity<>(savedinstitute,HttpStatus.CREATED);
		 
	}
	
	
	//build getInstitutebyid rest Api
	@GetMapping("{id}")
	public ResponseEntity<Institute> getByInstituteId(@PathVariable("id")Long instituteid){
		
	Institute institute=instituteService.getInstituteById(instituteid);
		
		return new ResponseEntity<>(institute,HttpStatus.OK);
		
		
	}
	
	//build getAllinstitutes rest Api
	@GetMapping
	public ResponseEntity<List<Institute>> getAllInstitutes(){
		
		List<Institute> Allinstitutes=instituteService.getAllinstitutes();
		
		return new  ResponseEntity<>(Allinstitutes,HttpStatus.OK);
	}
	
	//nuild Update institute rest Api
	@PutMapping("{id}")
	public ResponseEntity<Institute> UpdateInstitute(@PathVariable("id")long instituteid ,@RequestBody Institute institute){
		institute.setId(instituteid);
		Institute updatedinstitute=instituteService.updateinstitute(institute);
		return new ResponseEntity<>(updatedinstitute,HttpStatus.OK);
	}
	
	//Build deleteInstituteResApi
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteinstituteById(@PathVariable ("id")long instituteid){
		
		instituteService.deletInstituteById(instituteid);
		
		return new ResponseEntity<>("Institute Successfully deleted",HttpStatus.OK);
		
	}
	

}
