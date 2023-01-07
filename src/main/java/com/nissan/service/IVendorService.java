package com.nissan.service;

import java.util.List;

import com.nissan.model.Vendor;

public interface IVendorService {

	//add new vendor
	Vendor addNewVendor(Vendor vendor);
	
	//update vendor By Id
	Vendor updateVendorById(Integer _vendorId, Vendor _vendor);
	
	//list all vendors
	List<Vendor> listAllVendors();
	
	//delete a vendor by id
	Vendor deleteVendorById(Integer _vendorId);
	
	//search a vendor by name
	Vendor searchVendorByName(String _vendorName);
}
