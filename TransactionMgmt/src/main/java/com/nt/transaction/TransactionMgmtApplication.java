package com.nt.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nt.transaction.model.Employee;
import com.nt.transaction.model.Insurance;
import com.nt.transaction.service.OrganizationService;

@SpringBootApplication
public class TransactionMgmtApplication implements CommandLineRunner {

	@Autowired
	private OrganizationService orgService;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(TransactionMgmtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Employee emp = new Employee();
		emp.setEmpName("Ashih");
		
		Insurance ins = new Insurance();
		ins.setHealthInsuranceSchemeName("FamilyTopUp");
		ins.setCoverageAmount(200000);
		
		orgService.onBoardEmployee(emp, ins);
		
	}

}
