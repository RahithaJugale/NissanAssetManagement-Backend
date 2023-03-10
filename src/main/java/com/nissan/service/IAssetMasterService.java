package com.nissan.service;

import java.util.List;

import com.nissan.model.AssetMaster;

public interface IAssetMasterService {

	// add new asset master
	AssetMaster addNewAssetMaster(AssetMaster assetMaster);

	// update AssetMaster by id
	AssetMaster updateAssetMasterById(Integer _assetMasterId, AssetMaster assetMaster);

	// list all AssetMaster
	List<AssetMaster> listAllAssetMaster();

	// delete a AssetMaster by id
	AssetMaster deleteAssetMasterById(Integer _assetMasterId);

	// search AssetMaster by id
	AssetMaster searchAssetMasterById(Integer _assetMasterId);
}
