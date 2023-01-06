package com.nareshit.derivedmethod.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nareshit.derivedmethod.model.Employee;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {

	// Abstract Metho for the Named Query having Group by Clause
	
	public List<Object[]> findMaxSalariesByDept(List<String> deptNames);
}
