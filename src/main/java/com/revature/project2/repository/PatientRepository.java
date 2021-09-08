package com.revature.project2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import com.revature.project2.model.Patient;
import com.revature.project2.model.PatientBookings;

public interface PatientRepository extends  CrudRepository<Patient, Integer>{
	
	
	
	public Optional<Patient> findByPatientIdAndPatientPassword(int patientId, String patientPassword);

}
