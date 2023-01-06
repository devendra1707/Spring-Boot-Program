package com.nt.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.transaction.Dao.InsuranceDao;
import com.nt.transaction.model.Insurance;

@Service
public class InsuranceService {

	@Autowired
	private InsuranceDao insDao;
	
	public Insurance registerInsurance(Insurance ins) {
		return insDao.save(ins);
	}
}
