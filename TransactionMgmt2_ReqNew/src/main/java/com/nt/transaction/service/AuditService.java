package com.nt.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.transaction.Dao.AuditDao;
import com.nt.transaction.model.Audit;

@Service
public class AuditService {

	@Autowired
	private AuditDao auditDao;
	
	public Audit recordAudit(Audit audit) {
		return auditDao.save(audit);
	}
}
