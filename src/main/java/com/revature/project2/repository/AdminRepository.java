package com.revature.project2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.revature.project2.model.Admin;
import com.revature.project2.model.Doctor;

import com.revature.project2.model.PatientBookings;

public interface AdminRepository extends CrudRepository< Admin, Integer>{
	
	
	 public Optional<Admin> findByAdminIdAndAdminPassword(int adminId, String adminPassword);
     
         
     //public List<PatientBookings> findByPatientId(int patientId);
	 //use findById() // patient im  not doing doctor im doing ko& few admin


	

}
