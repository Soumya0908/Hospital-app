package com.revature.project2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project2.model.DoctorAvailability;
import com.revature.project2.repository.DoctorAvailablityRepository;

@Service
public class DoctorAvailabilityServiceImpl implements DoctorAvailabilityService{
	
	@Autowired
	DoctorAvailablityRepository doctorAvailabilityRepository;

	@Override
	public boolean addDoctorAvailability(DoctorAvailability doctorAvailability) {
		
		 doctorAvailabilityRepository.save(doctorAvailability);
		 return true;
	}

	@Override
	public boolean updateDoctorAvailability(DoctorAvailability doctorAvailability) {
		doctorAvailabilityRepository.save(doctorAvailability);
		 return true;
	}

	@Override
	public List<DoctorAvailability> getAllAvailability() {
		List<DoctorAvailability> availabilities=(List<DoctorAvailability>) doctorAvailabilityRepository.findAll();
		return availabilities;
	}

	

	@Override
	public List<DoctorAvailability> getDoctorAvailabilityBySerialNo(int serialNo) {
		List<DoctorAvailability> availabilities=(List<DoctorAvailability>) doctorAvailabilityRepository.findDoctorBySerialNo(serialNo);
		return availabilities;
	}

	@Override
	public List<DoctorAvailability> getDoctorAvailabilityByDoctorId(int doctorId) {
		List<DoctorAvailability> availabilities=(List<DoctorAvailability>) doctorAvailabilityRepository.findDoctorAvailabilityByDoctorId(doctorId);
		return availabilities;
	}

}
