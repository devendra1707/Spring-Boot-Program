package com.nt.transaction.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "audit")
public class Audit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "audit_id")
	private Integer auditId;
	
	@Column(name = "description")
	private String description;

	// Employee Ramu created Successfully
	//Insurance of Ramu failed
	public Integer getAuditId() {
		return auditId;
	}

	public void setAuditId(Integer auditId) {
		this.auditId = auditId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Audit(String description) {
		
		this.description = description;
	}

	public Audit() { }

	@Override
	public String toString() {
		return "Audit [auditId=" + auditId + ", description=" + description + "]";
	}
	
	
}
