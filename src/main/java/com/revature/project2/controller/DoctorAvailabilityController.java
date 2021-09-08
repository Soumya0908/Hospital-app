package com.revature.project2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revature.project2.model.Doctor;
import com.revature.project2.model.DoctorAvailability;
import com.revature.project2.model.PatientBookings;
import com.revature.project2.service.DoctorAvailabilityService;
import com.revature.project2.service.DoctorService;
import com.revature.project2.service.PatientBookingService;
@Controller
@RequestMapping("DoctorAvailability")
@CrossOrigin(origins="http://localhost:4200")
public class DoctorAvailabilityController {
	
	@Autowired
	DoctorService doctorService;
     
	@Autowired
	DoctorAvailabilityService doctorAvailabilityService;
	
	@Autowired
	PatientBookingService patientBookingService;
	
	@PostMapping
	public ResponseEntity<String> addDoctorAvailability(@RequestBody DoctorAvailability doctorAvailability){
		ResponseEntity<String> responseEntity = null;
		int doctorId =doctorAvailability.getSerialNo();
		String message= null;
		doctorAvailabilityService.addDoctorAvailability(doctorAvailability);
		message="Doctor with doctorId " +doctorId +"availability added successfully";
		responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
		return responseEntity;	
	}
	
	// get all doctors
		@GetMapping("/getDoctorAvailabilities")
		public ResponseEntity<List<DoctorAvailability>> getAllAvailability() {
			ResponseEntity<List<DoctorAvailability>> responseEntity = null;
			List<DoctorAvailability> availabilities = doctorAvailabilityService.getAllAvailability();
			if (availabilities.size() == 0) {
				responseEntity = new ResponseEntity<List<DoctorAvailability>>(availabilities, HttpStatus.OK);
			} else
				responseEntity = new ResponseEntity<List<DoctorAvailability>>(availabilities, HttpStatus.OK);
			return responseEntity;
		}

		// localhost:9090/doctoravailability/getDoctorAvailabilityByDomain/1

		@GetMapping("/getDoctorAvailabilityByDomain/{doctorDomain}")
		public ResponseEntity<List<Doctor>> getDoctorAvailabilityByDoctorDomain(@PathVariable("doctorDomain") String doctorDomain) {
			ResponseEntity<List<Doctor>> responseEntity = null;
			  List<Doctor> doctor = new ArrayList<Doctor>();
			  doctor= doctorService.getDoctorByDomain(doctorDomain);
			  System.out.println(doctor);
			  responseEntity =new ResponseEntity<List<Doctor>>(doctor,HttpStatus.OK);
			  return  responseEntity; 
			  		}

		@GetMapping("/getDoctorAvailabilityBySerialNo/{serialNo}")
		public ResponseEntity<List<DoctorAvailability>> getDoctorBySerialNo(@PathVariable("serialNo") int serialNo) {
			ResponseEntity<List<DoctorAvailability>> responseEntity = null;
			  List<DoctorAvailability> doctorAvailability = new ArrayList<DoctorAvailability>();
			  doctorAvailability= doctorAvailabilityService.getDoctorAvailabilityBySerialNo(serialNo);
			  System.out.println(doctorAvailability);
			  responseEntity =new ResponseEntity<List<DoctorAvailability>>(doctorAvailability,HttpStatus.OK);
			  return  responseEntity; 
			  	

	}
		
		@GetMapping("/getDoctorAvailabilityByDoctorId/{doctorId}")
		public ResponseEntity<List<DoctorAvailability>> getDoctorAvailabilityByDoctorId(@PathVariable("doctorId") int doctorId) {
			ResponseEntity<List<DoctorAvailability>> responseEntity = null;
			  List<DoctorAvailability> doctorAvailability = new ArrayList<DoctorAvailability>();
			  if(doctorService.isDoctorExists(doctorId)) {
				  doctorAvailability= doctorAvailabilityService.getDoctorAvailabilityByDoctorId(doctorId);
			   responseEntity =new ResponseEntity<List<DoctorAvailability>>(doctorAvailability,HttpStatus.OK);
			   } 
			  else
			  { 
				  responseEntity = new ResponseEntity<List<DoctorAvailability>>(doctorAvailability,HttpStatus.OK);
			 } 
			  return  responseEntity; 
			  }		


	
	/*
	 * @PostMapping public ResponseEntity<String> addDoctor(@RequestBody Doctor
	 * doctor) { ResponseEntity<String> responseEntity=null; int
	 * doctorId=doctor.getDoctorId(); String message=null;
	 * if(doctorService.isDoctorExists(doctorId)) {
	 * message="Doctor with doctorId "+doctorId+" already exists"; responseEntity
	 * =new ResponseEntity<String>(message,HttpStatus.OK); }
	 * 
	 * else { doctorService.addDoctor(doctor);
	 * message="Doctor with doctorId "+doctorId+" saved successfully";
	 * responseEntity =new ResponseEntity<String>(message,HttpStatus.OK); }
	 * 
	 * System.out.println(doctor); return responseEntity;
	 * 
	 * }
	 */

	/*
	 * @GetMapping("/getBookingsBydoctorId/{doctorId}") public List<PatientBookings>
	 * getBookingstByDoctorId(@PathVariable("doctorId") int doctorId) {
	 * System.out.println("getBookingsByDoctorId called..."); return
	 * patientBookingService.getBookingByDoctorId(doctorId); }
	 */
	
		
		  @GetMapping("/searchPatientBookingsByDoctorId/{doctorId}") 
		  public ResponseEntity<List<PatientBookings>> getPatientBookings(@PathVariable("doctorId") int doctorId){
		  ResponseEntity<List<PatientBookings>> responseEntity = null;
		  List<PatientBookings> patientBookings = new ArrayList<PatientBookings>();
		  if(doctorService.isDoctorExists(doctorId)) {
		   patientBookings= patientBookingService.viewBookings(doctorId); 
		   responseEntity =new ResponseEntity<List<PatientBookings>>(patientBookings,HttpStatus.OK);
		   } 
		  else
		  { 
			  responseEntity = new ResponseEntity<List<PatientBookings>>(patientBookings,HttpStatus.OK);
		 } 
		  return responseEntity; 
		  }
		  
@PutMapping
public ResponseEntity<String> updateDoctorAvailability(@RequestBody DoctorAvailability doctorAvailability){
	ResponseEntity<String> responseEntity = null;
	String message= null;
	doctorAvailabilityService.updateDoctorAvailability(doctorAvailability);
	message="Doctor with doctorId availability added successfully";
	responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
	return responseEntity;
				
}	 

}
