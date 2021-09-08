package com.revature.project2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revature.project2.model.PatientBookings;
import com.revature.project2.service.PatientBookingService;

@Controller
@RequestMapping("PatientBookingController")
@CrossOrigin(origins="http://localhost:4200")
public class PatientBookingController {
	
	@Autowired
	PatientBookingService patientBookingService;
	
	//Patient Bookings
		@PostMapping
		public ResponseEntity<String> addAppointment(@RequestBody PatientBookings patientBookings) {
			ResponseEntity<String> responseEntity = null;
			int PatientBookingId = patientBookings.getSerialNumber();
			String message = null;
			patientBookingService.addPatientBookings(patientBookings);
			System.out.println(patientBookings);
			message = "PatientBookings with PatientBooking Id " + PatientBookingId + " saved successfully";
			responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
			return responseEntity;

		}
		
		@GetMapping("/getPatientBookings")
		public ResponseEntity<List<PatientBookings>> getAllAppointments() {
			ResponseEntity<List<PatientBookings>> responseEntity = null;
			List<PatientBookings> bookings = patientBookingService.viewBookings();
			if (bookings.size() == 0) {
				responseEntity = new ResponseEntity<List<PatientBookings>>(bookings, HttpStatus.OK);
			} else
				responseEntity = new ResponseEntity<List<PatientBookings>>(bookings, HttpStatus.OK);
			return responseEntity;
		}

		
		
		@GetMapping("/getBookingsByPatientId/{patientId}")
		public List<PatientBookings> getBookingstByPatientId(@PathVariable("patientId") int patientId) {
			System.out.println("getBookingsByPatientId called...");
			return patientBookingService.getByPatientid(patientId);
		}

		

}
