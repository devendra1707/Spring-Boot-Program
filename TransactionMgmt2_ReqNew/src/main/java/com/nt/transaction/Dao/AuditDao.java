package com.nt.transaction.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nt.transaction.model.Audit;

@Repository
public interface AuditDao extends JpaRepository<Audit, Integer>  {

}
