package com.nt.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.transaction.Dao.EmployeeDao;
import com.nt.transaction.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao empDao;
	
	public Employee saveEmployee(Employee emp) {
		return empDao.save(emp);
	}
}
