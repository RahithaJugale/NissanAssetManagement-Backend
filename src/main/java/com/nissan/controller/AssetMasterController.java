package com.nissan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.model.AssetMaster;
import com.nissan.service.IAssetMasterService;

@RestController
@RequestMapping("api/")
public class AssetMasterController {

	@Autowired
	IAssetMasterService assetMasterServiceImplementation;
	
	// add new asset master
	@PostMapping("assetMasters")
	public AssetMaster addNewAssetMaster(@RequestBody AssetMaster assetMaster) {
		return assetMasterServiceImplementation.addNewAssetMaster(assetMaster);
	}
	
	// update AssetMaster by id
	@PutMapping("assetMasters/{_assetMasterId}")
	public AssetMaster updateAssetMasterById(@PathVariable Integer _assetMasterId, @RequestBody AssetMaster _assetMaster) {
		return assetMasterServiceImplementation.updateAssetMasterById(_assetMasterId, _assetMaster);
	}
	
	// list all AssetMaster
	@GetMapping("assetMasters")
	public List<AssetMaster> listAllAssetMaster() {
		return assetMasterServiceImplementation.listAllAssetMaster();
	}
	
	// delete a AssetMaster by id
	@DeleteMapping("assetMasters/{_assetMasterId}")
	public AssetMaster deleteAssetMasterById(@PathVariable Integer _assetMasterId) {
		return assetMasterServiceImplementation.deleteAssetMasterById(_assetMasterId);
	}
	
	// search AssetMaster by id
	@GetMapping("assetMasters/{_assetMasterId}")
	public AssetMaster searchAssetMasterById(@PathVariable Integer _assetMasterId) {
		return assetMasterServiceImplementation.searchAssetMasterById(_assetMasterId);
	}
}
