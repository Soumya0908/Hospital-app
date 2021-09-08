package com.revature.project2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.revature.project2.model.Doctor;
import com.revature.project2.model.DoctorAvailability;


public interface DoctorRepository extends CrudRepository<Doctor, Integer> {
	

	public Optional<Doctor> findByDoctorIdAndDoctorPassword(int doctorId, String doctorPassword);
	
     //public List<DoctorAvailability> findByDoctorDomainAndDoctorStatus(String doctorDomain, String doctorStatus);
	
	public List<Doctor> findByDoctorDomain(String doctorDomain);


}
