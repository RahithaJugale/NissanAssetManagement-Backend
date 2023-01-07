package com.nissan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PurchaseStatus {

	//instance variables
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer statusId;
	private String status;
	
	//default constructor
	public PurchaseStatus() {
	}

	//parameterized constructor
	public PurchaseStatus(Integer statusId, String status) {
		super();
		this.statusId = statusId;
		this.status = status;
	}

	//getters and setters
	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	//toString()
	@Override
	public String toString() {
		return "PurchaseStatus [statusId=" + statusId + ", status=" + status + "]";
	}
	
}
