package com.nissan.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.common.NoRecordFoundException;
import com.nissan.common.Validation;
import com.nissan.model.AssetType;
import com.nissan.repo.IAssetTypeRepository;

@Service
public class AssetTypeServiceImplementation implements IAssetTypeService {
	
	@Autowired
	IAssetTypeRepository assetTypeRepository;

	Validation validation = new Validation();

	// add new asset type
//	@Override
//	@Transactional
//	public AssetType addNewAssetType(AssetType assetType) {
//		if (validation.isNameValid(assetType.getTypeName())) {
//			return assetTypeRepository.save(assetType);
//		}
//		return null;
//	}
	
	@Override
	@Transactional
	public AssetType addNewAssetType(AssetType assetType) {
		try {
			if (validation.isNameValid(assetType.getTypeName())) {
				System.out.println(new Date());
//				System.out.println(assetType.getAssetTypeId());
//				assetTypeRepository.insertOrUpdateAssetType(assetType.getAssetTypeId(), assetType.getTypeName(), assetType.getIsActive());
				return assetType;
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	// update an asset type by id
	@Override
	@Transactional
	public AssetType updateAssetTypeById(Integer _assetTypeId, AssetType _assetType) {
		try {

			AssetType assetType = assetTypeRepository.findById(_assetTypeId).get();
			if (assetType == null) {
				throw new NoRecordFoundException("Id is not present in the database");
			} else {
				if (validation.isNameValid(_assetType.getTypeName())) {
					assetType.setTypeName(_assetType.getTypeName());
					assetType.setIsActive(_assetType.getIsActive());
					return assetTypeRepository.save(assetType);
				}
			}
		} catch (NoRecordFoundException e) {
			e.getMessage();
		}
		return null;
	}

	// list all asset types
	@Override
	public List<AssetType> listAllAssetTypes() {
		return assetTypeRepository.findAll();
	}

	// delete an asset type by id
	@Override
	@Transactional
	public AssetType deleteAssetTypeById(Integer _assetTypeId) {
		try {

			AssetType assetType = assetTypeRepository.findById(_assetTypeId).get();
			if (assetType == null) {
				throw new NoRecordFoundException("Id is not present in the database");
			} else {
				assetType.setIsActive(false);
				return assetTypeRepository.save(assetType);
			}
		} catch (NoRecordFoundException e) {
			e.getMessage();
		}
		return null;
	}

	// search an asset type
	@Override
	public AssetType searchByName(String _typeName) {
		return assetTypeRepository.getAssetTypeByName(_typeName);
	}

}
