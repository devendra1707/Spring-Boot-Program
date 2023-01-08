package com.nt.transaction.service;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.transaction.model.Audit;
import com.nt.transaction.model.Employee;
import com.nt.transaction.model.Insurance;

@Service
public class OrganizationService // Parent
{

	@Autowired
	private EmployeeService empService;    //Child1

	@Autowired
	private InsuranceService insService;   //Child2


	@Autowired
	private AuditService auditService;  //Child3

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	// Communicating Database to start transaction block
	//This will start Transactional Block
	// Default Behavior ==> (propagation = Propagation.REQUIRED)
	//Communicating Database to start transaction block //T1 WILL BE CREATED
		public void onBoardEmployee(Employee emp, Insurance ins) {


			Employee employee = empService.saveEmployee(emp);  //T1

			if (employee.getEmpId() != null) {
				//T2
				auditService.recordAudit(new Audit("Employee creation is sucess for " + employee.getEmpName()));
				ins.setEmpId(employee.getEmpId());

			} else {
				//2
				auditService.recordAudit(new Audit("Employee creation is Failed for " + employee.getEmpName()));
			}




			if (ins.getHealthInsuranceSchemeName().length() <= 4) {
				//T3
				auditService.recordAudit(new Audit("Insurance creation is Failed for  with insurance Name ....."
						+ ins.getHealthInsuranceSchemeName() + ".....For the Employe ...." + employee.getEmpName()));
				throw new RuntimeErrorException(null, "Error in Insurance");
			}

			else {
				//T1

				insService.registerInsurance(ins);
				//T3
				auditService.recordAudit(new Audit("Insurance creation is Sucess for " + employee.getEmpName()));
			}

			//t1 ===> Org, Emp,Ins services
			//t2 and t3  ==> Audit Service
		}

}
