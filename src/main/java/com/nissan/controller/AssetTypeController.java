package com.nissan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.model.AssetType;
import com.nissan.service.IAssetTypeService;
@CrossOrigin
@RestController
@RequestMapping("api/")
public class AssetTypeController {

	@Autowired
	IAssetTypeService assetTypeService;

	// add new asset type
	@PostMapping("assetTypes")
	public AssetType addNewAssetType(@RequestBody AssetType assetType) {
		return assetTypeService.addNewAssetType(assetType);
	}

	// update an asset type by Id
	@PutMapping("assetTypes/{_assetTypeId}")
	public AssetType updateAssetTypeById(@PathVariable Integer _assetTypeId, @RequestBody AssetType _assetType) {
		return assetTypeService.updateAssetTypeById(_assetTypeId, _assetType);
	}

	// list all asset types
	@GetMapping("assetTypes")
	public List<AssetType> listAllAssetTypes() {
		return assetTypeService.listAllAssetTypes();
	}

	// delete an asset type By Id
	@DeleteMapping("assetTypes/{_assetTypeId}")
	public AssetType deleteAssetTypeById(@PathVariable Integer _assetTypeId) {
		return assetTypeService.deleteAssetTypeById(_assetTypeId);
	}

	// search an asset type by name
	@GetMapping("assetTypes/{_typeName}")
	public AssetType searchByName(@PathVariable String _typeName) {
		return assetTypeService.searchByName(_typeName);
	}
}
