package com.revature.project2.service;

import java.util.List;

import com.revature.project2.model.Doctor;
import com.revature.project2.model.Patient;
import com.revature.project2.model.PatientBookings;


public interface PatientService {
	
	public boolean addPatient(Patient patient);
	public boolean patientLogin(int patientId, String patientPassword);
	public boolean deletePatient(int patientId);
	public List<Patient> getAllPatients();
	public Patient getPatientById(int patientId);
	public boolean isPatientExists(int patientId);
	public boolean updatePatient(Patient patient);
	
}
