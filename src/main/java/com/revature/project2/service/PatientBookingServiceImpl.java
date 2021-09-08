package com.revature.project2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project2.model.PatientBookings;
import com.revature.project2.repository.PatientBookingsRepository;

@Service
public class PatientBookingServiceImpl implements PatientBookingService {
	
	@Autowired
	PatientBookingsRepository patientBookingsRepository;

	@Override
	public List<PatientBookings> viewBookings() {
		// TODO Auto-generated method stub
		return patientBookingsRepository.findAll();
	}

	

	@Override
	public List<PatientBookings> viewBookings(int doctorId) {
		
		return patientBookingsRepository.findByDoctorId(doctorId);
	}

	@Override
	public boolean addPatientBookings(PatientBookings patientBookings) {
		 patientBookingsRepository.save(patientBookings);
		 return true;
		
	}


	@Override
	public boolean updateBooking(PatientBookings patientBookings) {
		patientBookingsRepository.save(patientBookings);
		return true;
	}

	@Override
	public List<PatientBookings> getBookingByDoctorId(int doctorId) {
		List<PatientBookings> bookingData = (List<PatientBookings>)patientBookingsRepository.findByDoctorId(doctorId);
		return bookingData;
	}

	@Override
	public boolean deleteBooking(int serialNumber) {
		patientBookingsRepository.deleteById(serialNumber);
		return true;
	}



	@Override
	public List<PatientBookings> getByPatientid(int patientId) {
		List<PatientBookings> bookingData = (List<PatientBookings>)patientBookingsRepository.findByPatientId(patientId);
		return bookingData;
	}

}
