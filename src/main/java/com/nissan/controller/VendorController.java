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

import com.nissan.model.Vendor;
import com.nissan.service.IVendorService;
import com.nissan.util.JwtUtils;
@CrossOrigin
@RestController
@RequestMapping("api/")
public class VendorController {

	@Autowired
	IVendorService vendorService;
	
	@Autowired
	private JwtUtils jwtutil;
	
	// add new vendor
	@PostMapping("vendors")
	public Vendor addNewVendor(@RequestHeader(value="authorization", defaultValue="")String auth, @RequestBody Vendor vendor) throws Exception{
		jwtutil.verify(auth);
		return vendorService.addNewVendor(vendor);
	}
	
	// update vendor By Id
	@PutMapping("vendors/{_vendorId}")
	public Vendor updateVendorById(@RequestHeader(value="authorization", defaultValue="")String auth, @PathVariable Integer _vendorId, @RequestBody Vendor _vendor) throws Exception{
		jwtutil.verify(auth);
		return vendorService.updateVendorById(_vendorId, _vendor);
	}
	
	// list all vendors
	@GetMapping("vendors")
	public List<Vendor> listAllVendors(@RequestHeader(value="authorization", defaultValue="")String auth) throws Exception {
		jwtutil.verify(auth);
		return vendorService.listAllVendors();
	}
	
	// delete a vendor by id
	@DeleteMapping("vendors/{_vendorId}")
	public Vendor deleteVendorById(@RequestHeader(value="authorization", defaultValue="")String auth, @PathVariable Integer _vendorId) throws Exception{
		jwtutil.verify(auth);
		return vendorService.deleteVendorById(_vendorId);
	}
	
	// search a vendor by name
	@GetMapping("vendors/{_vendorName}")
	public Vendor searchVendorByName(@RequestHeader(value="authorization", defaultValue="")String auth, @PathVariable String _vendorName) throws Exception{
		jwtutil.verify(auth);
		return vendorService.searchVendorByName(_vendorName);
	}
}
