package com.revature.project2.service;

import java.util.List;

import com.revature.project2.model.DoctorAvailability;

public interface DoctorAvailabilityService {
	
	public boolean addDoctorAvailability(DoctorAvailability doctorAvailability);
	
	public boolean updateDoctorAvailability(DoctorAvailability doctorAvailability);

	public List<DoctorAvailability> getAllAvailability();
	
	public List<DoctorAvailability> getDoctorAvailabilityBySerialNo(int serialNo);
	
	public List<DoctorAvailability> getDoctorAvailabilityByDoctorId(int doctorId);
}
