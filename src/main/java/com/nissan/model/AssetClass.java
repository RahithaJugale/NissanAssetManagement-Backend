package com.nissan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AssetClass {

	//instance variables
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer classId;
	private String className;
	
	//default constructor
	public AssetClass() {

	}

	//parameterized constructor
	public AssetClass(Integer classId, String className) {
		super();
		this.classId = classId;
		this.className = className;
	}

	//getters and setters
	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	//toString()
	@Override
	public String toString() {
		return "AssetClass [classId=" + classId + ", className=" + className + "]";
	}
}
