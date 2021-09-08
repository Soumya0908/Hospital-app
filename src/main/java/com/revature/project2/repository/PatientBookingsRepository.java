package com.revature.project2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.revature.project2.model.PatientBookings;

public interface PatientBookingsRepository extends  JpaRepository<PatientBookings, Integer> {
	
   //public List<PatientBookings> findByDoctorDomain(String doctorDomain);
	
	@Query("SELECT p from PatientBookings p where patientId=:patientId")
	public List<PatientBookings> findByPatientId(int patientId);
	
	@Query("SELECT p from PatientBookings p where doctorId=:doctorId")
	public List<PatientBookings> findByDoctorId(int doctorId);
	
	//public PatientBookings findAPatientBookings();
	@Query("SELECT p from PatientBookings p where patientId=:patientId")
	public List<PatientBookings> getBookingByPatientId(@Param("patientId") int patientId);


}
