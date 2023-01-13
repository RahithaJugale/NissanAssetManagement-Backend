package com.nissan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
public class AssetMaster {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer assetMasterId;
	private Integer assetTypeId;
	private Integer vendorId;
	private Integer assetDefinitionId;
	private String model;
	private String serialNumber;
	private String manufacturingYear;
	private String purchaseDate;
	private Boolean warranty;
	private String warrantyFrom;
	private String warrantyTo;
	
	@OneToOne
	@JoinColumn(name="assetTypeId", referencedColumnName="assetTypeId", insertable=false, updatable=false)
	private AssetType assetType;
	
	@OneToOne
	@JoinColumn(name="vendorId", referencedColumnName="vendorId", insertable=false, updatable=false)
	private Vendor vendor;
	
	@OneToOne
	@JoinColumn(name="assetDefinitionId", referencedColumnName="assetDefinitionId", insertable=false, updatable=false)
	private AssetDefinition assetDefinition;
	
	private Boolean isActive;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime createdAt;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime updatedAt;

	//default constructor
	public AssetMaster() {

	}

	//parameterized constructor
	public AssetMaster(Integer assetMasterId, Integer assetTypeId, Integer vendorId, Integer assetDefinitionId,
			String model, String serialNumber, String manufacturingYear, String purchaseDate, Boolean warranty,
			String warrantyFrom, String warrantyTo, Boolean isActive) {
		super();
		this.assetMasterId = assetMasterId;
		this.assetTypeId = assetTypeId;
		this.vendorId = vendorId;
		this.assetDefinitionId = assetDefinitionId;
		this.model = model;
		this.serialNumber = serialNumber;
		this.manufacturingYear = manufacturingYear;
		this.purchaseDate = purchaseDate;
		this.warranty = warranty;
		this.warrantyFrom = warrantyFrom;
		this.warrantyTo = warrantyTo;
		this.isActive = isActive;
	}

	public AssetMaster(Integer assetMasterId, Integer assetTypeId, Integer vendorId, Integer assetDefinitionId,
			String model, String serialNumber, String manufacturingYear, String purchaseDate, Boolean warranty,
			String warrantyFrom, String warrantyTo, AssetType assetType, Vendor vendor, AssetDefinition assetDefinition,
			Boolean isActive, DateTime createdAt, DateTime updatedAt) {
		super();
		this.assetMasterId = assetMasterId;
		this.assetTypeId = assetTypeId;
		this.vendorId = vendorId;
		this.assetDefinitionId = assetDefinitionId;
		this.model = model;
		this.serialNumber = serialNumber;
		this.manufacturingYear = manufacturingYear;
		this.purchaseDate = purchaseDate;
		this.warranty = warranty;
		this.warrantyFrom = warrantyFrom;
		this.warrantyTo = warrantyTo;
		this.assetType = assetType;
		this.vendor = vendor;
		this.assetDefinition = assetDefinition;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public AssetMaster(Integer assetMasterId, Integer assetTypeId, Integer vendorId, Integer assetDefinitionId,
			String model, String serialNumber, String manufacturingYear, String purchaseDate, Boolean warranty,
			String warrantyFrom, String warrantyTo, Boolean isActive, DateTime createdAt, DateTime updatedAt) {
		super();
		this.assetMasterId = assetMasterId;
		this.assetTypeId = assetTypeId;
		this.vendorId = vendorId;
		this.assetDefinitionId = assetDefinitionId;
		this.model = model;
		this.serialNumber = serialNumber;
		this.manufacturingYear = manufacturingYear;
		this.purchaseDate = purchaseDate;
		this.warranty = warranty;
		this.warrantyFrom = warrantyFrom;
		this.warrantyTo = warrantyTo;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	//getters and setters
	public Integer getAssetMasterId() {
		return assetMasterId;
	}

	public void setAssetMasterId(Integer assetMasterId) {
		this.assetMasterId = assetMasterId;
	}

	public Integer getAssetTypeId() {
		return assetTypeId;
	}

	public void setAssetTypeId(Integer assetTypeId) {
		this.assetTypeId = assetTypeId;
	}

	public Integer getVendorId() {
		return vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public Integer getAssetDefinitionId() {
		return assetDefinitionId;
	}

	public void setAssetDefinitionId(Integer assetDefinitionId) {
		this.assetDefinitionId = assetDefinitionId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getManufacturingYear() {
		return manufacturingYear;
	}

	public void setManufacturingYear(String manufacturingYear) {
		this.manufacturingYear = manufacturingYear;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Boolean getWarranty() {
		return warranty;
	}

	public void setWarranty(Boolean warranty) {
		this.warranty = warranty;
	}

	public String getWarrantyFrom() {
		return warrantyFrom;
	}

	public void setWarrantyFrom(String warrantyFrom) {
		this.warrantyFrom = warrantyFrom;
	}

	public String getWarrantyTo() {
		return warrantyTo;
	}

	public void setWarrantyTo(String warrantyTo) {
		this.warrantyTo = warrantyTo;
	}

	public AssetType getAssetType() {
		return assetType;
	}

	public void setAssetType(AssetType assetType) {
		this.assetType = assetType;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public AssetDefinition getAssetDefinition() {
		return assetDefinition;
	}

	public void setAssetDefinition(AssetDefinition assetDefinition) {
		this.assetDefinition = assetDefinition;
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
		return "AssetMaster [assetMasterId=" + assetMasterId + ", assetTypeId=" + assetTypeId + ", vendorId=" + vendorId
				+ ", assetDefinitionId=" + assetDefinitionId + ", model=" + model + ", serialNumber=" + serialNumber
				+ ", manufacturingYear=" + manufacturingYear + ", purchaseDate=" + purchaseDate + ", warranty="
				+ warranty + ", warrantyFrom=" + warrantyFrom + ", warrantyTo=" + warrantyTo + ", assetType="
				+ assetType + ", vendor=" + vendor + ", assetDefinition=" + assetDefinition + ", isActive=" + isActive
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
}
