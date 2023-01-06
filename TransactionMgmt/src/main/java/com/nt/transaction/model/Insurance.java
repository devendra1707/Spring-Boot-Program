package com.nt.transaction.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "emp_health")
public class Insurance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "insurance_id")
	private Integer insuranceId;

	private Integer empId;

	@Column(name = "healthInsuranceSchemeName")
	private String healthInsuranceSchemeName;

	private int coverageAmount;

	public Integer getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(Integer insuranceId) {
		this.insuranceId = insuranceId;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getHealthInsuranceSchemeName() {
		return healthInsuranceSchemeName;
	}

	public void setHealthInsuranceSchemeName(String healthInsuranceSchemeName) {
		this.healthInsuranceSchemeName = healthInsuranceSchemeName;
	}

	public int getCoverageAmount() {
		return coverageAmount;
	}

	public void setCoverageAmount(int coverageAmount) {
		this.coverageAmount = coverageAmount;
	}

	public Insurance(Integer insuranceId, Integer empId, String healthInsuranceSchemeName, int coverageAmount) {
		super();
		this.insuranceId = insuranceId;
		this.empId = empId;
		this.healthInsuranceSchemeName = healthInsuranceSchemeName;
		this.coverageAmount = coverageAmount;
	}

	public Insurance() {
	}

	@Override
	public String toString() {
		return "Insurance [insuranceId=" + insuranceId + ", empId=" + empId + ", healthInsuranceSchemeName="
				+ healthInsuranceSchemeName + ", coverageAmount=" + coverageAmount + "]";
	}

}
