package com.revature.project2.model;



import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
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

@Entity
@Table(name="doctors_availability")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorAvailability {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int serialNo;
	
	@Column(nullable=false)
	@Basic
	@Temporal(TemporalType.DATE)
	private Date availableDate;
	
	@Column(nullable=false)
	@Basic
	@Temporal(TemporalType.TIME)
	@JsonFormat(pattern = "HH:mm")
	private Date availableTime;
	
	
	private String status;
	
	
	
	  @ManyToOne
	  
	  @JoinColumns({
	  
	  @JoinColumn(name="doctor_Id", referencedColumnName="doctorId"), }) 
	  private Doctor doctor;
	 
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumns({
	 * 
	 * @JoinColumn(name="doctor_Name", referencedColumnName="doctorName"),
	 * 
	 * @JoinColumn(name="doctor_Domain", referencedColumnName="doctorDomain"),
	 * 
	 * @JoinColumn(name="doctor_Experience",
	 * referencedColumnName="doctorExperience"),
	 * 
	 * @JoinColumn(name="doctor_MobileNo", referencedColumnName="doctorMobileNo") })
	 * private Doctor doctor;
	 */

	
	

}
