package com.nissan.service;

import java.util.List;

import com.nissan.model.AssetDefinition;

public interface IAssetDefinitionService {

	// add new asset
	AssetDefinition addNewAsset(AssetDefinition assetDefinition);

	// update an asset by ID
	AssetDefinition updateAssetById(Integer _assetDefinitionId, AssetDefinition _assetDefinition);

	// list all assets
	List<AssetDefinition> listAllAssets();

	// delete an asset
	AssetDefinition deleteAssetById(Integer _assetDefinitionId);

	// search an asset by name
	AssetDefinition searchAssetByName(String _name);
}
