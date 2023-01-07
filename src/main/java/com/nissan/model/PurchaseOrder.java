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
public class PurchaseOrder {
	
	//instance variables
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer purchaseOrderId;
	private String purchaseOrderNo;
	private Integer assetDefinitionId;
	private Integer assetTypeId;
	private Integer quantity;
	private Integer vendorId;
	private String orderDate;
	private String deliveryDate;
	private Integer statusId;
	
	@OneToOne
	@JoinColumn(name="assetTypeId", referencedColumnName="assetTypeId", insertable=false, updatable=false)
	private AssetType assetType;
	
	@OneToOne
	@JoinColumn(name="assetDefinitionId", referencedColumnName="assetDefinitionId", insertable=false, updatable=false)
	private AssetDefinition assetDefinition;
	
	@OneToOne
	@JoinColumn(name="vendorId", referencedColumnName="vendorId", insertable=false, updatable=false)
	private Vendor vendor;
	
	@OneToOne
	@JoinColumn(name="statusId", referencedColumnName="statusId", insertable=false, updatable=false)
	private PurchaseStatus purchaseStatus;

	private Boolean isActive;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime createdAt;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime updatedAt;

	//default constructor
	public PurchaseOrder() {

	}

	//parameterized constructor
	public PurchaseOrder(Integer purchaseOrderId, String purchaseOrderNo, Integer assetDefinitionId,
			Integer assetTypeId, Integer quantity, Integer vendorId, String orderDate, String deliveryDate,
			Integer statusId, Boolean isActive) {
		super();
		this.purchaseOrderId = purchaseOrderId;
		this.purchaseOrderNo = purchaseOrderNo;
		this.assetDefinitionId = assetDefinitionId;
		this.assetTypeId = assetTypeId;
		this.quantity = quantity;
		this.vendorId = vendorId;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.statusId = statusId;
		this.isActive = isActive;
	}

	public PurchaseOrder(Integer purchaseOrderId, String purchaseOrderNo, Integer assetDefinitionId,
			Integer assetTypeId, Integer quantity, Integer vendorId, String orderDate, String deliveryDate,
			Integer statusId, Boolean isActive, DateTime createdAt, DateTime updatedAt) {
		super();
		this.purchaseOrderId = purchaseOrderId;
		this.purchaseOrderNo = purchaseOrderNo;
		this.assetDefinitionId = assetDefinitionId;
		this.assetTypeId = assetTypeId;
		this.quantity = quantity;
		this.vendorId = vendorId;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.statusId = statusId;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public PurchaseOrder(Integer purchaseOrderId, String purchaseOrderNo, Integer assetDefinitionId,
			Integer assetTypeId, Integer quantity, Integer vendorId, String orderDate, String deliveryDate,
			Integer statusId, AssetType assetType, AssetDefinition assetDefinition, Vendor vendor,
			PurchaseStatus purchaseStatus, Boolean isActive, DateTime createdAt, DateTime updatedAt) {
		super();
		this.purchaseOrderId = purchaseOrderId;
		this.purchaseOrderNo = purchaseOrderNo;
		this.assetDefinitionId = assetDefinitionId;
		this.assetTypeId = assetTypeId;
		this.quantity = quantity;
		this.vendorId = vendorId;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.statusId = statusId;
		this.assetType = assetType;
		this.assetDefinition = assetDefinition;
		this.vendor = vendor;
		this.purchaseStatus = purchaseStatus;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	//getters and setters
	public Integer getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(Integer purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public String getPurchaseOrderNo() {
		return purchaseOrderNo;
	}

	public void setPurchaseOrderNo(String purchaseOrderNo) {
		this.purchaseOrderNo = purchaseOrderNo;
	}

	public Integer getAssetDefinitionId() {
		return assetDefinitionId;
	}

	public void setAssetDefinitionId(Integer assetDefinitionId) {
		this.assetDefinitionId = assetDefinitionId;
	}

	public Integer getAssetTypeId() {
		return assetTypeId;
	}

	public void setAssetTypeId(Integer assetTypeId) {
		this.assetTypeId = assetTypeId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getVendorId() {
		return vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public AssetType getAssetType() {
		return assetType;
	}

	public void setAssetType(AssetType assetType) {
		this.assetType = assetType;
	}

	public AssetDefinition getAssetDefinition() {
		return assetDefinition;
	}

	public void setAssetDefinition(AssetDefinition assetDefinition) {
		this.assetDefinition = assetDefinition;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public PurchaseStatus getPurchaseStatus() {
		return purchaseStatus;
	}

	public void setPurchaseStatus(PurchaseStatus purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
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
		return "PurchaseOrder [purchaseOrderId=" + purchaseOrderId + ", purchaseOrderNo=" + purchaseOrderNo
				+ ", assetDefinitionId=" + assetDefinitionId + ", assetTypeId=" + assetTypeId + ", quantity=" + quantity
				+ ", vendorId=" + vendorId + ", orderDate=" + orderDate + ", deliveryDate=" + deliveryDate
				+ ", statusId=" + statusId + ", assetType=" + assetType + ", assetDefinition=" + assetDefinition
				+ ", vendor=" + vendor + ", purchaseStatus=" + purchaseStatus + ", isActive=" + isActive
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
}
