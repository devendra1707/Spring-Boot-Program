package com.nt.transaction.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.transaction.model.Insurance;

public interface InsuranceDao extends JpaRepository<Insurance, Integer> {

}
