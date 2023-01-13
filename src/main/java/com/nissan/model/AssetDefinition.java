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
public class AssetDefinition {
	
	//instance variables
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer assetDefinitionId;
	
	@Column(nullable=false)
	private String name;
	private Integer assetTypeId;
	private Integer classId;
	
	@ManyToOne
	@JoinColumn(name="assetTypeId", insertable=false, updatable=false)
	private AssetType assetType;
	
	@ManyToOne
	@JoinColumn(name="classId", insertable=false, updatable=false)
	private AssetClass assetClass;

	private Boolean isActive;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime createdAt;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime updatedAt;

	//default constructor
	public AssetDefinition() {

	}

	//parameterized constructor
	public AssetDefinition(Integer assetDefinitionId, String name, Integer assetTypeId, Integer classId, AssetType assetType,
			Boolean isActive, DateTime createdAt, DateTime updatedAt) {
		super();
		this.assetDefinitionId = assetDefinitionId;
		this.name = name;
		this.assetTypeId = assetTypeId;
		this.classId = classId;
		this.assetType = assetType;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public AssetDefinition(Integer assetDefinitionId, String name, Integer assetTypeId, Integer classId, Boolean isActive,
			DateTime createdAt, DateTime updatedAt) {
		super();
		this.assetDefinitionId = assetDefinitionId;
		this.name = name;
		this.assetTypeId = assetTypeId;
		this.classId = classId;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public AssetDefinition(Integer assetDefinitionId, String name, Integer assetTypeId, Integer classId,
			AssetType assetType, AssetClass assetClass, Boolean isActive) {
		super();
		this.assetDefinitionId = assetDefinitionId;
		this.name = name;
		this.assetTypeId = assetTypeId;
		this.classId = classId;
		this.assetType = assetType;
		this.assetClass = assetClass;
		this.isActive = isActive;
	}

	//getters and setters
	public Integer getassetDefinitionId() {
		return assetDefinitionId;
	}

	public void setassetDefinitionId(Integer assetDefinitionId) {
		this.assetDefinitionId = assetDefinitionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAssetTypeId() {
		return assetTypeId;
	}

	public void setAssetTypeId(Integer assetTypeId) {
		this.assetTypeId = assetTypeId;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
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
		return "AssetDefinition [assetDefinitionId=" + assetDefinitionId + ", name=" + name + ", assetTypeId=" + assetTypeId + ", classId="
				+ classId + ", assetType=" + assetType + ", isActive=" + isActive + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}
}
