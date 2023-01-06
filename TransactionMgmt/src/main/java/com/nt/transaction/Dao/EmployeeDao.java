package com.nt.transaction.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nt.transaction.model.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
