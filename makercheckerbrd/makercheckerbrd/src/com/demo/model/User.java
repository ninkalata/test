package com.demo.model;

import java.util.Date;

public class User {

	private int customerId;

	private String customerCode;
	private String customerName;
	private String customerAddress1;
	private String customerAddress2;
	private int customerPinCode;
	private String emailaddress;
	private int contactNumber;
	private String primaryContactPerson;
	private String recordStatus;
	private String activeInactiveFlag;
	private  Date createDate;
	private String createBy;
	private Date modifiedDate;
	private String modifiedBy;
	private Date authorizedDate;
	private String authorizedBy;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress1() {
		return customerAddress1;
	}
	public void setCustomerAddress1(String customerAddress1) {
		this.customerAddress1 = customerAddress1;
	}
	public String getCustomerAddress2() {
		return customerAddress2;
	}
	public void setCustomerAddress2(String customerAddress2) {
		this.customerAddress2 = customerAddress2;
	}
	public int getCustomerPinCode() {
		return customerPinCode;
	}
	public void setCustomerPinCode(int customerPinCode) {
		this.customerPinCode = customerPinCode;
	}
	public String getEmailaddress() {
		return emailaddress;
	}
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
	public int getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getPrimaryContactPerson() {
		return primaryContactPerson;
	}
	public void setPrimaryContactPerson(String primaryContactPerson) {
		this.primaryContactPerson = primaryContactPerson;
	}
	public String getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	public String getActiveInactiveFlag() {
		return activeInactiveFlag;
	}
	public void setActiveInactiveFlag(String activeInactiveFlag) {
		this.activeInactiveFlag = activeInactiveFlag;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getAuthorizedDate() {
		return authorizedDate;
	}
	public void setAuthorizedDate(Date authorizedDate) {
		this.authorizedDate = authorizedDate;
	}
	public String getAuthorizedBy() {
		return authorizedBy;
	}
	public void setAuthorizedBy(String authorizedBy) {
		this.authorizedBy = authorizedBy;
	}
	@Override
	public String toString() {
		return "User [customerId=" + customerId + ", customerCode=" + customerCode + ", customerName=" + customerName
				+ ", customerAddress1=" + customerAddress1 + ", customerAddress2=" + customerAddress2
				+ ", customerPinCode=" + customerPinCode + ", emailaddress=" + emailaddress + ", contactNumber="
				+ contactNumber + ", primaryContactPerson=" + primaryContactPerson + ", recordStatus=" + recordStatus
				+ ", activeInactiveFlag=" + activeInactiveFlag + ", createDate=" + createDate + ", createBy=" + createBy
				+ ", modifiedDate=" + modifiedDate + ", modifiedBy=" + modifiedBy + ", authorizedDate=" + authorizedDate
				+ ", authorizedBy=" + authorizedBy + "]";
	}
}