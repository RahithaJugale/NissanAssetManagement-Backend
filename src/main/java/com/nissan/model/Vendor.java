package com.nissan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
public class Vendor {

	//instance variable
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer vendorId;
	
	@Column(nullable=false)
	private String vendorName;
	private String vendorType;
	private Integer assetTypeId;
	private String vendorFrom;
	private String vendorTo;
	private String vendorAddress;
	
	@ManyToOne
	@JoinColumn(name="assetTypeId", insertable=false, updatable=false)
	private AssetType assetType;
	
	private Boolean isActive;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime createdAt;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime updatedAt;

	//default constructor
	public Vendor() {

	}

	//parameterized constructor

	public Vendor(Integer vendorId, String vendorName, String vendorType, Integer assetTypeId, String vendorFrom,
			String vendorTo, String vendorAddress, AssetType assetType, Boolean isActive, DateTime createdAt,
			DateTime updatedAt) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.vendorType = vendorType;
		this.assetTypeId = assetTypeId;
		this.vendorFrom = vendorFrom;
		this.vendorTo = vendorTo;
		this.vendorAddress = vendorAddress;
		this.assetType = assetType;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Vendor(Integer vendorId, String vendorName, String vendorType, Integer assetTypeId, String vendorFrom,
			String vendorTo, String vendorAddress, Boolean isActive, DateTime createdAt, DateTime updatedAt) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.vendorType = vendorType;
		this.assetTypeId = assetTypeId;
		this.vendorFrom = vendorFrom;
		this.vendorTo = vendorTo;
		this.vendorAddress = vendorAddress;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	
	public Vendor(Integer vendorId, String vendorName, String vendorType, Integer assetTypeId, String vendorFrom,
			String vendorTo, String vendorAddress, AssetType assetType, Boolean isActive) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.vendorType = vendorType;
		this.assetTypeId = assetTypeId;
		this.vendorFrom = vendorFrom;
		this.vendorTo = vendorTo;
		this.vendorAddress = vendorAddress;
		this.assetType = assetType;
		this.isActive = isActive;
	}

	//getters and setters
	
	public Integer getVendorId() {
		return vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorType() {
		return vendorType;
	}

	public void setVendorType(String vendorType) {
		this.vendorType = vendorType;
	}

	public Integer getAssetTypeId() {
		return assetTypeId;
	}

	public void setAssetTypeId(Integer assetTypeId) {
		this.assetTypeId = assetTypeId;
	}

	public String getVendorFrom() {
		return vendorFrom;
	}

	public void setVendorFrom(String vendorFrom) {
		this.vendorFrom = vendorFrom;
	}

	public String getVendorTo() {
		return vendorTo;
	}

	public void setVendorTo(String vendorTo) {
		this.vendorTo = vendorTo;
	}

	public String getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public AssetType getAssetType() {
		return assetType;
	}

	public void setAssetType(AssetType assetType) {
		this.assetType = assetType;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public DateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(DateTime createdAt) {
		this.createdAt = createdAt;
	}

	public DateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(DateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@PrePersist
	public void onSave() {
		DateTime dateTime = new DateTime();
		this.createdAt = dateTime;
		this.updatedAt = dateTime;
	}

	@PostPersist
	public void onUpdate() {
		DateTime dateTime = new DateTime();
		this.updatedAt = dateTime;
	}

	//toString()
	@Override
	public String toString() {
		return "Vendor [vendorId=" + vendorId + ", vendorName=" + vendorName + ", vendorType=" + vendorType
				+ ", assetTypeId=" + assetTypeId + ", vendorFrom=" + vendorFrom + ", vendorTo=" + vendorTo
				+ ", vendorAddress=" + vendorAddress + ", assetType=" + assetType + ", isActive=" + isActive
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}	
}
