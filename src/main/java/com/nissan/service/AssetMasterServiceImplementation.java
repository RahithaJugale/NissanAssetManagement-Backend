package com.nissan.service;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.model.AssetMaster;
import com.nissan.repo.IAssetMasterRepository;

@Service
public class AssetMasterServiceImplementation implements IAssetMasterService {

	@Autowired
	IAssetMasterRepository assetMasterRepository;

	// add new asset master
	@Override
	@Transactional
	public AssetMaster addNewAssetMaster(AssetMaster assetMaster) {
		try {
			if (((new SimpleDateFormat("dd/MM/yyyy").parse(assetMaster.getWarrantyTo()))
					.compareTo(new SimpleDateFormat("dd/MM/yyyy").parse(assetMaster.getWarrantyFrom())) > 0)) {
				return assetMasterRepository.save(assetMaster);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	// update AssetMaster by id
	@Override
	@Transactional
	public AssetMaster updateAssetMasterById(Integer _assetMasterId, AssetMaster _assetMaster) {
		AssetMaster assetMaster = assetMasterRepository.findById(_assetMasterId).get();
		assetMaster.setAssetTypeId(_assetMaster.getAssetTypeId());
		assetMaster.setAssetDefinitionId(_assetMaster.getAssetDefinitionId());
		assetMaster.setVendorId(_assetMaster.getVendorId());
		assetMaster.setModel(_assetMaster.getModel());
		assetMaster.setSerialNumber(_assetMaster.getSerialNumber());
		assetMaster.setManufacturingYear(_assetMaster.getManufacturingYear());
		assetMaster.setWarranty(_assetMaster.getWarranty());
		assetMaster.setPurchaseDate(_assetMaster.getManufacturingYear());
		assetMaster.setWarrantyFrom(_assetMaster.getWarrantyFrom());
		assetMaster.setWarrantyTo(_assetMaster.getWarrantyTo());
		assetMaster.setIsActive(_assetMaster.getIsActive());
		try {
			if (((new SimpleDateFormat("dd/MM/yyyy").parse(assetMaster.getWarrantyTo()))
					.compareTo(new SimpleDateFormat("dd/MM/yyyy").parse(assetMaster.getWarrantyFrom())) > 0)) {
				return assetMasterRepository.save(assetMaster);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

	// list all AssetMaster
	@Override
	public List<AssetMaster> listAllAssetMaster() {
		return assetMasterRepository.findAll();
	}

	// delete a AssetMaster by id
	@Override
	@Transactional
	public AssetMaster deleteAssetMasterById(Integer _assetMasterId) {
		AssetMaster assetMaster = assetMasterRepository.findById(_assetMasterId).get();
		assetMaster.setIsActive(false);
		return assetMasterRepository.save(assetMaster);
	}

	// search AssetMaster by id
	@Override
	public AssetMaster searchAssetMasterById(Integer _assetMasterId) {
		return assetMasterRepository.findById(_assetMasterId).get();
	}

}
