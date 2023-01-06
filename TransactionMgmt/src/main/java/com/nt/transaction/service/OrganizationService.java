package com.nt.transaction.service;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.transaction.model.Employee;
import com.nt.transaction.model.Insurance;

import jakarta.transaction.Transactional;

@Service
public class OrganizationService {

	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private InsuranceService insService;
	
	@Transactional  // Communicating Database to start transaction block
	public void onBoardEmployee(Employee emp, Insurance ins) {
		// Employee Will be saved
		empService.saveEmployee(emp);
		
		
		if(ins.getHealthInsuranceSchemeName().length() <= 5) {
			
			throw new RuntimeErrorException(null, "Error in Insurance as Scheme Name is <= 5");
				
		}else {
			// EmployeeId Will be set to Insurance Object
			ins.setEmpId(emp.getEmpId());
			// Insurance will be saved
			insService.registerInsurance(ins);
		}
	}
}
