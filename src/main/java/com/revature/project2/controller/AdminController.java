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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.revature.project2.model.Admin;
import com.revature.project2.model.Doctor;
import com.revature.project2.model.DoctorAvailability;
import com.revature.project2.model.Patient;
import com.revature.project2.service.AdminService;
import com.revature.project2.service.DoctorAvailabilityService;
import com.revature.project2.service.DoctorService;
import com.revature.project2.service.PatientService;



@Controller
@RequestMapping("Admin")
@CrossOrigin(origins ="http://localhost:4200")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	DoctorService doctorService;
	
	@Autowired
	PatientService patientService;
	
	@Autowired
	DoctorAvailabilityService doctorAvailabilityService;
	
@GetMapping("/searchByAdminIdAndAdminPassword/{adminId}/{adminPassword}")
public ResponseEntity<Admin> adminLogin(@PathVariable("adminId") int adminId, @PathVariable("adminPassword") String adminPassword){
	
		 ResponseEntity<Admin> responseEntity=null;
		Admin admin =new Admin();
		 boolean res=false;		
		 res=adminService.adminLogin(adminId,adminPassword);
		 if(res) {
		admin=adminService.getAdminById(adminId); 
		responseEntity=new ResponseEntity<Admin> (admin,HttpStatus.OK);
		 System.out.println("logged successfully");
		 } 
		 else {
		 responseEntity=new ResponseEntity<Admin> (admin,HttpStatus.OK);
		 System.out.println("Your login details are not matched");
		 }
		
		 return responseEntity;
		  
		
	}

//Registering Doctor 

		@PostMapping
		public ResponseEntity<String> addDoctor(@RequestBody Doctor doctor) {
			ResponseEntity<String> responseEntity=null;
			int doctorId=doctor.getDoctorId();
			String message=null;
			if(doctorService.isDoctorExists(doctorId)) {
			message="Doctor with doctorId "+doctorId+" already exists";
			responseEntity =new ResponseEntity<String>(message,HttpStatus.OK);
			}
			
			else {
				doctorService.addDoctor(doctor);
				message="Doctor with doctorId "+doctorId+" saved successfully";
				responseEntity =new ResponseEntity<String>(message,HttpStatus.OK);
			}
			
			System.out.println(doctor);
			return responseEntity;
			
		}


//Fetching all the Doctors-List from DataBase
@GetMapping
public ResponseEntity<List<Doctor>> getDoctors(@RequestParam(required = false)  String doctorDomain){
	 ResponseEntity<List<Doctor>> responseEntity = null;
	 List<Doctor> doctor= new ArrayList<Doctor>();
	 if(doctorDomain == null) {
		 doctor = doctorService.getDoctorByDomain(doctorDomain);
	 }
	 else {
		 doctor = doctorService.getAllDoctors(); 
	 }
	 if(doctor.size() == 0) {
		 responseEntity = new ResponseEntity<List<Doctor>>(doctor, HttpStatus.OK);
	 }
	 else {
		 responseEntity = new ResponseEntity<List<Doctor>>(doctor, HttpStatus.OK);
	 }
	 return responseEntity;
}

//get doctor by id
@GetMapping("{doctorId}")
public ResponseEntity<Doctor> getDoctorById(@PathVariable("doctorId") int doctorId) {
	ResponseEntity<Doctor> responseEntity=null;
	Doctor doctor =new Doctor();
	if(doctorService.isDoctorExists(doctorId)) {
	doctor=doctorService.viewDoctorDetails(doctorId);
	responseEntity=new ResponseEntity<Doctor> (doctor,HttpStatus.OK);
	}
	else
	responseEntity=new ResponseEntity<Doctor> (doctor,HttpStatus.OK);
	return responseEntity;
}

//Deleting the doctor Details ById
@DeleteMapping("{doctorId}")
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
		




}
