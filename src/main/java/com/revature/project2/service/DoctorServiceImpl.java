package com.revature.project2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project2.model.Doctor;
import com.revature.project2.model.DoctorAvailability;

import com.revature.project2.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	DoctorRepository doctorRepository;

	@Override
	public boolean doctorLogin(int doctorId, String doctorPassword) {
		
		Optional<Doctor> doctorData= doctorRepository.findByDoctorIdAndDoctorPassword(doctorId, doctorPassword);
		return doctorData.isPresent();
	}

	@Override
	public boolean updateDoctorDetails(Doctor doctor) {
		doctorRepository.save(doctor);
		return true;
	}

	@Override
	public Doctor viewDoctorDetails(int doctorId) {
		Optional<Doctor> doctorData = doctorRepository.findById(doctorId);
		Doctor doctor = doctorData.get();	
		return doctor;
	}

	@Override
	public boolean addDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		 doctorRepository.save(doctor);
		 return true;
	}

	@Override
	public boolean deleteDoctor(int doctorId) {
		doctorRepository.deleteById(doctorId);
		return true;
	}

	@Override
	public List<Doctor> getAllDoctors() {
		// TODO Auto-generated method stub
		return (List<Doctor>) doctorRepository.findAll();
	}

	
	@Override
	public boolean isDoctorExists(int doctorId) {
		Optional<Doctor> doctorData = doctorRepository.findById(doctorId);
		return doctorData.isPresent();
	}

	@Override
	public List<Doctor> getDoctorByDomain(String doctorDomain) {
		// TODO Auto-generated method stub
		return doctorRepository.findByDoctorDomain(doctorDomain) ;
	}



}
