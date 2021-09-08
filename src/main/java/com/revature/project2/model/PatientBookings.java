package com.revature.project2.model;



import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="patient_Bookings")
@AllArgsConstructor
@NoArgsConstructor
public class PatientBookings {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int serialNumber;
	

	private int patientId;
	private String patientName;
	private int patientAge;
	private int doctorId;
	private String doctorName;
	private String doctorDomain;
	private String doctorExperience;
	private String doctorMobileNo;
	
	@Basic
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(style = "hh:mm")
	private Date availableTime;
	
	@Basic
	@Temporal(TemporalType.DATE)
	private Date availableDate;
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumns({
	 * 
	 * @JoinColumn(name="patient_id", referencedColumnName="patientId"),
	 * 
	 * @JoinColumn(name="patient_name", referencedColumnName="patientName"),
	 * 
	 * @JoinColumn(name="patient_age", referencedColumnName="patientAge") }) private
	 * Patient patient;
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumns({
	 * 
	 * @JoinColumn(name="doctor_id", referencedColumnName="doctorId"),
	 * 
	 * @JoinColumn(name="doctor_name",referencedColumnName="doctorName"),
	 * 
	 * @JoinColumn(name="doctor_domain", referencedColumnName="doctorDomain"),
	 * 
	 * @JoinColumn(name="doctor_experience",
	 * referencedColumnName="doctorExperience") }) private Doctor doctor;
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumns({
	 * 
	 * @JoinColumn(name="available_date", referencedColumnName="availableDate"),
	 * 
	 * @JoinColumn(name="available_time", referencedColumnName="availableTime") })
	 * private DoctorAvailability doctorAvailability;
	 */
}
