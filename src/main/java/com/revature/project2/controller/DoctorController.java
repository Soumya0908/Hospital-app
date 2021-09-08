package com.revature.project2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revature.project2.model.Doctor;
import com.revature.project2.model.DoctorAvailability;
import com.revature.project2.model.PatientBookings;
import com.revature.project2.service.DoctorService;
import com.revature.project2.service.PatientBookingService;
import com.revature.project2.service.PatientService;

@Controller
@RequestMapping("Doctor")
@CrossOrigin(origins ="http://localhost:4200")
public class DoctorController {
	
	@Autowired
	DoctorService doctorService;
	
	@Autowired
	PatientService patientService;
	
	
	
@GetMapping("/searchByDoctorIdAndDoctorPassword/{doctorId}/{doctorPassword}")
	public ResponseEntity<Doctor> doctorLogin(@PathVariable("doctorId") int doctorId,
			                   @PathVariable("doctorPassword") String doctorPassword){
		ResponseEntity<Doctor> responseEntity = null;
		Doctor doctor= new Doctor();
		 boolean res=false;	
		 res= doctorService.doctorLogin(doctorId, doctorPassword);
		if(res) {
			doctor= doctorService.viewDoctorDetails(doctorId);
			responseEntity=new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
			System.out.println("You have logged in successfully");		
		}
		else {
			responseEntity=new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
			System.out.println("Sorry ID or Pasword is inavlid");
		}
		return responseEntity;
	}
@GetMapping("/getDoctorslist")
public ResponseEntity<List<Doctor>> getAllDoctors() {
	ResponseEntity<List<Doctor>> responseEntity = null;
	List<Doctor> doctor = doctorService.getAllDoctors();
	if (doctor.size() == 0) {
		responseEntity = new ResponseEntity<List<Doctor>>(doctor, HttpStatus.OK);
	} else
		responseEntity = new ResponseEntity<List<Doctor>>(doctor, HttpStatus.OK);
	return responseEntity;
}

@DeleteMapping("/deletedoctorbyId/{doctorId}")
public ResponseEntity<String> deleteDoctor(@PathVariable("doctorId") int doctorId) {
	ResponseEntity<String> responseEntity=null;
	
	String message=null;
	if(doctorService.isDoctorExists(doctorId)) {
		doctorService.deleteDoctor(doctorId);
	message="Doctor with doctorId "+doctorId+" deleted Successfully";
	responseEntity =new ResponseEntity<String>(message,HttpStatus.OK);
	}
	else {
		
		message="Doctor with doctorId "+doctorId+" not exist";
		responseEntity =new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	
	return responseEntity;
}

@GetMapping("/searchByDoctorId/{doctorId}")
public ResponseEntity<Doctor> getDoctorById(@PathVariable("doctorId") int doctorId){
	ResponseEntity<Doctor> responseEntity = null;
	Doctor doctor = new Doctor();
	if(doctorService.isDoctorExists(doctorId)) {
		doctor = doctorService.viewDoctorDetails(doctorId);
		responseEntity = new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
	}
	else {
		responseEntity = new ResponseEntity<Doctor>(doctor, HttpStatus.OK);

	}
	return responseEntity;
}

@PutMapping
public ResponseEntity<String> updateMyProfile(@RequestBody Doctor doctor){
   ResponseEntity<String> responseEntity = null;
   int doctorId= doctor.getDoctorId();
   String message= null;
   if(doctorService.isDoctorExists(doctorId)) {
	   doctorService.updateDoctorDetails(doctor);
	   message="Doctor with doctorId" +doctorId + "updated Successfully";
	   responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
   }
   else {
	   message="Doctor with doctorId" +doctorId+ "does not exist";
	   responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
   }
   return responseEntity;
}
}
