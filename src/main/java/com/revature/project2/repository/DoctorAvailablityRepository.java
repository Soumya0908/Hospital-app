package com.revature.project2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.project2.model.Doctor;
import com.revature.project2.model.DoctorAvailability;

@Repository
public interface DoctorAvailablityRepository extends CrudRepository<DoctorAvailability,Integer>{
	
	/*
	 * @Query("select new com.revature.project2.model.Doctor(d.doctorName, d.doctorDomain, d.doctorExperience, d.doctorMobileNo)from com.revature.project2.model.Doctor d, DoctorAvailability a where d.doctorId = :a.serialNo "
	 * ) public List<DoctorAvailability> join();
	 */
	
	@Query("SELECT a from DoctorAvailability a where doctorDomain=:doctorDomain")
	public List<Doctor> findDoctorByDoctorDomain(@Param("doctorDomain") String doctorDomain);

	@Query("SELECT a from DoctorAvailability a where serialNo=:serialNo")
	public List<DoctorAvailability> findDoctorBySerialNo(@Param("serialNo") int serialNo);
	
	@Query("SELECT a from DoctorAvailability a where doctor_Id=:doctor_Id")
	public List<DoctorAvailability> findDoctorAvailabilityByDoctorId(@Param("doctor_Id") int doctorId);


}
