package com.revature.project2.service;

import java.util.List;

import com.revature.project2.model.Doctor;
import com.revature.project2.model.DoctorAvailability;
import com.revature.project2.model.Patient;

public interface DoctorService {
	
	public boolean addDoctor(Doctor doctor);
	public boolean doctorLogin(int doctorId, String doctorPassword);
	public boolean deleteDoctor(int doctorId);
	public List<Doctor> getAllDoctors();
	public boolean updateDoctorDetails(Doctor doctor);
	public Doctor viewDoctorDetails(int doctorId);
	public boolean isDoctorExists(int doctorId);
	public List<Doctor> getDoctorByDomain(String doctorDomain);
	
	
}
