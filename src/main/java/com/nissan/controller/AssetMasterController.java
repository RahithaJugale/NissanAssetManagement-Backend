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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.model.AssetMaster;
import com.nissan.service.IAssetMasterService;
import com.nissan.util.JwtUtils;
@CrossOrigin
@RestController
@RequestMapping("api/")
public class AssetMasterController {

	@Autowired
	IAssetMasterService assetMasterServiceImplementation;
	
	@Autowired
	private JwtUtils jwtutil;
	
	// add new asset master
	@PostMapping("assetMasters")
	public AssetMaster addNewAssetMaster(@RequestHeader(value="authorization", defaultValue="")String auth, @RequestBody AssetMaster assetMaster) throws Exception{
		jwtutil.verify(auth);
		return assetMasterServiceImplementation.addNewAssetMaster(assetMaster);
	}
	
	// update AssetMaster by id
	@PutMapping("assetMasters/{_assetMasterId}")
	public AssetMaster updateAssetMasterById(@RequestHeader(value="authorization", defaultValue="")String auth, @PathVariable Integer _assetMasterId, @RequestBody AssetMaster _assetMaster) throws Exception{
		jwtutil.verify(auth);
		return assetMasterServiceImplementation.updateAssetMasterById(_assetMasterId, _assetMaster);
	}
	
	// list all AssetMaster
	@GetMapping("assetMasters")
	public List<AssetMaster> listAllAssetMaster(@RequestHeader(value="authorization", defaultValue="")String auth) throws Exception{
		jwtutil.verify(auth);
		return assetMasterServiceImplementation.listAllAssetMaster();
	}
	
	// delete a AssetMaster by id
	@DeleteMapping("assetMasters/{_assetMasterId}")
	public AssetMaster deleteAssetMasterById(@RequestHeader(value="authorization", defaultValue="")String auth, @PathVariable Integer _assetMasterId) throws Exception {
		jwtutil.verify(auth);
		return assetMasterServiceImplementation.deleteAssetMasterById(_assetMasterId);
	}
	
	// search AssetMaster by id
	@GetMapping("assetMasters/{_assetMasterId}")
	public AssetMaster searchAssetMasterById(@RequestHeader(value="authorization", defaultValue="")String auth, @PathVariable Integer _assetMasterId) throws Exception{
		jwtutil.verify(auth);
		return assetMasterServiceImplementation.searchAssetMasterById(_assetMasterId);
	}
}
