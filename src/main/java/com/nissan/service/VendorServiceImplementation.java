package com.nissan.service;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.common.Validation;
import com.nissan.model.Vendor;
import com.nissan.repo.IVendorRepository;

@Service
public class VendorServiceImplementation implements IVendorService {

	@Autowired
	IVendorRepository vendorRepository;

	Validation validation = new Validation();

	// add new vendor
	@Override
	@Transactional
	public Vendor addNewVendor(Vendor vendor) {
		try {
			if (((new SimpleDateFormat("yyyy-MM-dd").parse(vendor.getVendorTo()))
					.compareTo(new SimpleDateFormat("yyyy-MM-dd").parse(vendor.getVendorFrom())) > 0)) {
				return vendorRepository.save(vendor);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}

	// update vendor By Id
	@Override
	@Transactional
	public Vendor updateVendorById(Integer _vendorId, Vendor _vendor) {
		try {
			Vendor vendor = vendorRepository.findById(_vendorId).get();
			if (validation.isNameValid(_vendor.getVendorName())) {
				vendor.setVendorName(_vendor.getVendorName());
				vendor.setVendorType(_vendor.getVendorType());
				vendor.setAssetTypeId(_vendor.getAssetTypeId());
				vendor.setVendorFrom(_vendor.getVendorFrom());
				vendor.setVendorTo(_vendor.getVendorTo());
				vendor.setVendorAddress(_vendor.getVendorAddress());
				vendor.setIsActive(_vendor.getIsActive());
				if (((new SimpleDateFormat("yyyy-MM-dd").parse(vendor.getVendorTo()))
						.compareTo(new SimpleDateFormat("yyyy-MM-dd").parse(vendor.getVendorFrom())) > 0)) {
					return vendorRepository.save(vendor);
				}
			}

		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	// list all vendors
	@Override
	public List<Vendor> listAllVendors() {
		return vendorRepository.findAll();
	}

	// delete a vendor by id
	@Override
	@Transactional
	public Vendor deleteVendorById(Integer _vendorId) {
		Vendor vendor = vendorRepository.findById(_vendorId).get();
		vendor.setIsActive(false);
		return vendorRepository.save(vendor);
	}

	// search a vendor by name
	@Override
	public Vendor searchVendorByName(String _vendorName) {
		return vendorRepository.getVendorByName(_vendorName);
	}

}
