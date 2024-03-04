package com.Institutes.institutesmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Institutes.institutesmanagement.Entity.Institute;

public interface InstituteRepository extends JpaRepository<Institute,Long> {

}
