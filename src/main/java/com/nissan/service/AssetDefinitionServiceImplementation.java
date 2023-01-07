package com.nissan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.common.NoRecordFoundException;
import com.nissan.common.Validation;
import com.nissan.model.AssetDefinition;
import com.nissan.repo.IAssetDefinitionRepository;

@Service
public class AssetDefinitionServiceImplementation implements IAssetDefinitionService {

	@Autowired
	IAssetDefinitionRepository assetDefinitionRepository;
	
	Validation validation = new Validation();
	
	//add new asset
	@Override
	@Transactional
	public AssetDefinition addNewAsset(AssetDefinition assetDefinition) {
		if (validation.isNameValid(assetDefinition.getName())) {
			return assetDefinitionRepository.save(assetDefinition);
		}
		return null;
	}

	//update an asset by ID
	@Override
	@Transactional
	public AssetDefinition updateAssetById(Integer _assetDefinitionId, AssetDefinition _assetDefinition) {
		
		try {

			AssetDefinition asset = assetDefinitionRepository.findById(_assetDefinitionId).get();
			if (asset == null) {
				throw new NoRecordFoundException("Id is not present in the database");
			} else {
				if (validation.isNameValid(_assetDefinition.getName())) {
					asset.setName(_assetDefinition.getName());
					asset.setClassId(_assetDefinition.getClassId());
					asset.setAssetTypeId(_assetDefinition.getAssetTypeId());
					asset.setIsActive(_assetDefinition.getIsActive());

					return assetDefinitionRepository.save(asset);
				}
			}
		} catch (NoRecordFoundException e) {
			e.getMessage();
		}
		return null;
	}

	//list all assets
	@Override
	public List<AssetDefinition> listAllAssets() {
		return assetDefinitionRepository.findAll();
	}

	//delete an asset by id
	@Override
	@Transactional
	public AssetDefinition deleteAssetById(Integer _assetDefinitionId) {
		AssetDefinition asset = assetDefinitionRepository.findById(_assetDefinitionId).get();
		asset.setIsActive(false);
		return assetDefinitionRepository.save(asset);
	}

	//search an asset by name
	@Override
	public AssetDefinition searchAssetByName(String _name) {
		return assetDefinitionRepository.getAssetByName(_name);
	}

}
