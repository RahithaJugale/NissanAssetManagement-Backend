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

import com.nissan.model.AssetType;
import com.nissan.service.IAssetTypeService;
import com.nissan.util.JwtUtils;
@CrossOrigin
@RestController
@RequestMapping("api/")
public class AssetTypeController {

	@Autowired
	IAssetTypeService assetTypeService;
	
	@Autowired
	private JwtUtils jwtutil;

	// add new asset type
	@PostMapping("assetTypes")
	public AssetType addNewAssetType(@RequestHeader(value="authorization", defaultValue="")String auth, @RequestBody AssetType assetType) throws Exception {
		jwtutil.verify(auth);
		return assetTypeService.addNewAssetType(assetType);
	}

	// update an asset type by Id
	@PutMapping("assetTypes/{_assetTypeId}")
	public AssetType updateAssetTypeById(@RequestHeader(value="authorization", defaultValue="")String auth, @PathVariable Integer _assetTypeId, @RequestBody AssetType _assetType) throws Exception{
		jwtutil.verify(auth);
		return assetTypeService.updateAssetTypeById(_assetTypeId, _assetType);
	}

	// list all asset types
	@GetMapping("assetTypes")
	public List<AssetType> listAllAssetTypes(@RequestHeader(value="authorization", defaultValue="")String auth) throws Exception {
		jwtutil.verify(auth);
		return assetTypeService.listAllAssetTypes();
	}

	// delete an asset type By Id
	@DeleteMapping("assetTypes/{_assetTypeId}")
	public AssetType deleteAssetTypeById(@RequestHeader(value="authorization", defaultValue="")String auth, @PathVariable Integer _assetTypeId) throws Exception {
		jwtutil.verify(auth);
		return assetTypeService.deleteAssetTypeById(_assetTypeId);
	}

	// search an asset type by name
	@GetMapping("assetTypes/{_typeName}")
	public AssetType searchByName(@RequestHeader(value="authorization", defaultValue="")String auth, @PathVariable String _typeName) throws Exception {
		jwtutil.verify(auth);
		return assetTypeService.searchByName(_typeName);
	}
}
