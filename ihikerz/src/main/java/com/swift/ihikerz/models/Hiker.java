package com.swift.ihikerz.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Hiker {

	@Id
	private String id;

	@Field
	private String name;

	@Field
	private String identityNo;

	@Field
	private String contactNo;

	@Field
	private String date;

	@Field
	private Date submitDate;

	@Field
	private String status;

	@Field
	private String hillName;

	public Hiker() {
		super();
	}

	public Hiker(String name, String identityNo, String contactNo, String date, String status, String hillName) {
		super();
		this.name = name;
		this.identityNo = identityNo;
		this.contactNo = contactNo;
		this.date = date;
		this.status = status;
		this.hillName = hillName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdentityNo() {
		return identityNo;
	}

	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}

	public String getHillName() {
		return hillName;
	}

	public void setHillName(String hillName) {
		this.hillName = hillName;
	}

	@Override
	public String toString() {
		return String.format("Hiker[id='%s', name='%s']", id, name);
	}

}
