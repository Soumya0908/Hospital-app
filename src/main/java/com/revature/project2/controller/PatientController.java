package com.revature.project2.controller;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revature.project2.model.Admin;
import com.revature.project2.model.Patient;
import com.revature.project2.service.PatientBookingService;
import com.revature.project2.service.PatientService;

@Controller
@RequestMapping("Patient")
@CrossOrigin(origins="http://localhost:4200")
public class PatientController {
	
	@Autowired
	PatientService patientService;
	
	@GetMapping("/searchByPatientIdAndPatientPassword/{patientId}/{patientPassword}")
	public ResponseEntity<Patient> adminLogin(@PathVariable("patientId") int patientId, @PathVariable("patientPassword") String patientPassword){
		
			ResponseEntity<Patient> responseEntity=null;
			Patient patient = new Patient();
			 boolean res=false;		
			 res=patientService.patientLogin(patientId,patientPassword);
			 if(res) {
			patient=patientService.getPatientById(patientId); 
			responseEntity=new ResponseEntity<Patient> (patient,HttpStatus.OK);
			 System.out.println("logged successfully");
			 } 
			 else {
			 responseEntity=new ResponseEntity<Patient> (patient,HttpStatus.OK);
			 System.out.println("Your login details are not matched");
			 }
			
			 return responseEntity;
			  
			
		}
	
	// get all patients
			@GetMapping("/getPatientsList")
			public ResponseEntity<List<Patient>> getAllPatients() {
				ResponseEntity<List<Patient>> responseEntity=null;
				List<Patient> patientList = patientService.getAllPatients();
				if(patientList.size()==0) {
					responseEntity=new ResponseEntity<List<Patient>>(patientList,HttpStatus.OK);
				}
				else
					responseEntity=new ResponseEntity<List<Patient>>(patientList,HttpStatus.OK);
				return responseEntity;
			}
			
			//get patient by id
			@GetMapping("/searchByPatientId/{patientId}")
			public ResponseEntity<Patient> getPatientById(@PathVariable("patientId") int patientId) {
				ResponseEntity<Patient> responseEntity=null;
				Patient patient =new Patient();
				if(patientService.isPatientExists(patientId)) {
					patient=patientService.getPatientById(patientId);
					responseEntity=new ResponseEntity<Patient> (patient,HttpStatus.OK);
				}
				else
					responseEntity=new ResponseEntity<Patient> (patient,HttpStatus.OK);
				
				return responseEntity;

			}
			
			//insert a patient
			@PostMapping
			public ResponseEntity<String> addPatient(@RequestBody Patient patient) {
				ResponseEntity<String> responseEntity=null;
				int patientId=patient.getPatientId();
				String message=null;
				if(patientService.isPatientExists(patientId)) {
				message="Patient with patientId "+patientId+" already exists";
				responseEntity =new ResponseEntity<String>(message,HttpStatus.NO_CONTENT);
				}
				else {
					patientService.addPatient(patient);
					message="Patient with patientId "+patientId+" saved successfully";
					responseEntity =new ResponseEntity<String>(message,HttpStatus.OK);
				}
				
				System.out.println(patient);
				return responseEntity;
				
			}
			//update a product
			@PutMapping
			public ResponseEntity<String> updatePatient(@RequestBody Patient patient) {
				ResponseEntity<String> responseEntity=null;
				int patientId=patient.getPatientId();
				String message=null;
				if(patientService.isPatientExists(patientId)) {
					patientService.updatePatient(patient);
				message="Patient with patientId "+patientId+" Updated Successfully";
				responseEntity =new ResponseEntity<String>(message,HttpStatus.OK);
				}
				else {
					
					message="Patient with patientId "+patientId+" not exist";
					responseEntity =new ResponseEntity<String>(message,HttpStatus.OK);
				}
				
				
				return responseEntity;
			}
			
			@DeleteMapping("{patientId}")
			public ResponseEntity<String> deletePatient(@PathVariable("patientId") int patientId) {
				ResponseEntity<String> responseEntity=null;
				
				String message=null;
				if(patientService.isPatientExists(patientId)) {
					patientService.deletePatient(patientId);
				message="Patient with patientId "+patientId+" deleted Successfully";
				responseEntity =new ResponseEntity<String>(message,HttpStatus.OK);
				}
				else {
					
					message="Patient with patientId "+patientId+" not exist";
					responseEntity =new ResponseEntity<String>(message,HttpStatus.OK);
				}
				
				
				return responseEntity;
			}


}
