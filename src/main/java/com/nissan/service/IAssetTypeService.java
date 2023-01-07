package com.nissan.service;

import java.util.List;

import com.nissan.model.AssetType;

public interface IAssetTypeService {

	// add new asset type
	AssetType addNewAssetType(AssetType assetType);

	// update an asset type by Id
	AssetType updateAssetTypeById(Integer _assetTypeId, AssetType _assetType);

	// list all asset types
	List<AssetType> listAllAssetTypes();

	// delete an asset type By Id
	AssetType deleteAssetTypeById(Integer _assetTypeId);

	// search an asset type by name
	AssetType searchByName(String _typeName);

}
