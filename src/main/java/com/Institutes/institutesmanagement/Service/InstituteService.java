package com.Institutes.institutesmanagement.Service;

import java.util.List;

import com.Institutes.institutesmanagement.Entity.Institute;

public interface InstituteService {
	
	Institute registerInstitute(Institute institute);
	
	Institute getInstituteById(Long institiuteid);
	
	List<Institute> getAllinstitutes();
	
	Institute updateinstitute(Institute institute);
	void deletInstituteById(Long Instituteid);
}
