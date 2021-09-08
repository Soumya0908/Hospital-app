package com.revature.project2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="doctors")
public class Doctor{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int doctorId;
	
	private String doctorName;
	
	
	private String doctorPassword;
	
	private String gender;
	
	
	private String doctorMobileNo;
	
	
	private String doctorEmail;
	
	private String doctorDomain;

	private String doctorExperience;

	private int doctorSalary;
	
}
