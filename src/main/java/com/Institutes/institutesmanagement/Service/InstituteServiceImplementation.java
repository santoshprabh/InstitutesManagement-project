package com.Institutes.institutesmanagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Institutes.institutesmanagement.Entity.Institute;
import com.Institutes.institutesmanagement.Repository.InstituteRepository;


@Service
public class InstituteServiceImplementation implements InstituteService {


	@Autowired
	public InstituteRepository instituterepository;
	
	
	public InstituteServiceImplementation(InstituteRepository instituterepository) {
		super();
		this.instituterepository = instituterepository;
	}


	@Override
	public Institute registerInstitute(Institute institute) {
	  
	return instituterepository.save(institute);
	}


	@Override
	public Institute getInstituteById(Long institiuteid) {
		  Optional<Institute> optionalinstitute=instituterepository.findById(institiuteid);
		return optionalinstitute.get();
	}


	@Override
	public List<Institute> getAllinstitutes() {
	     
		return  instituterepository.findAll();
	}


	@Override
	public Institute updateinstitute(Institute institute) {
		Institute exixtingInstitute=instituterepository.findById(institute.getId()).get();
		exixtingInstitute.setName(institute.getName());
		exixtingInstitute.setContact(institute.getContact());
		exixtingInstitute.setCourses(institute.getCourses());
		Institute updatedinstitute=instituterepository.save(exixtingInstitute);
		return updatedinstitute;
	}


	@Override
	public void deletInstituteById(Long Instituteid) {
		
		instituterepository.deleteById(Instituteid);
	}
	
	
	
	

}
