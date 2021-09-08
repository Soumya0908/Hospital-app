package com.revature.project2.service;


import org.springframework.stereotype.Service;

import com.revature.project2.model.Admin;


@Service
public interface AdminService {
	
	public boolean adminLogin(int adminId, String adminPassword);
	public Admin getAdminById(int adminId);

	
}
