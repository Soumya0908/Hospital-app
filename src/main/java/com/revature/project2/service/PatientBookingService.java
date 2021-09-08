package com.revature.project2.service;

import java.util.List;

import com.revature.project2.model.PatientBookings;

public interface PatientBookingService {
	
	public boolean addPatientBookings(PatientBookings patientBookings);
	public List<PatientBookings> viewBookings();
	public List<PatientBookings> getByPatientid(int patientId);
	public List<PatientBookings> viewBookings(int doctorId);
	public boolean deleteBooking(int serialNumber);
	public boolean updateBooking(PatientBookings patientBookings);
	public List<PatientBookings> getBookingByDoctorId(int doctorId);

}
