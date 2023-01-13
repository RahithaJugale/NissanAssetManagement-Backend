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

import com.nissan.model.AssetDefinition;
import com.nissan.service.IAssetDefinitionService;
import com.nissan.util.JwtUtils;
@CrossOrigin
@RestController
@RequestMapping("api/")
public class AssetDefinitionController {
	
	@Autowired
	IAssetDefinitionService assetDefinitionService;
	
	@Autowired
	private JwtUtils jwtUtil;

	// add new asset
	@PostMapping("assets")
	public AssetDefinition addNewAsset(@RequestHeader(value="authorization", defaultValue="")String auth, @RequestBody AssetDefinition assetDefinition) throws Exception {
		jwtUtil.verify(auth);
		return assetDefinitionService.addNewAsset(assetDefinition);
	}

	// update an asset by Id
	@PutMapping("assets/{_assetDefinitionId}")
	public AssetDefinition updateAssetById(@PathVariable Integer _assetDefinitionId, @RequestBody AssetDefinition _assetDefinition) {
		return assetDefinitionService.updateAssetById(_assetDefinitionId, _assetDefinition);
	}

	// list all assets
	@GetMapping("assets")
	public List<AssetDefinition> listAllAssets() {
		return assetDefinitionService.listAllAssets();
	}

	// delete an asset By Id
	@DeleteMapping("assets/{_assetDefinitionId}")
	public AssetDefinition deleteAssetById(@PathVariable Integer _assetDefinitionId) {
		return assetDefinitionService.deleteAssetById(_assetDefinitionId);
	}

	// search an asset by name
	@GetMapping("assets/{_name}")
	public AssetDefinition searchByAssetName(@PathVariable String _name) {
		return assetDefinitionService.searchAssetByName(_name);
	}
}
