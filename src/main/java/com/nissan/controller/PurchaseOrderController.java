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

import com.nissan.model.PurchaseOrder;
import com.nissan.model.PurchaseStatus;
import com.nissan.service.IPurchaseOrderService;
import com.nissan.util.JwtUtils;
@CrossOrigin
@RestController
@RequestMapping("api/")
public class PurchaseOrderController {

	@Autowired
	IPurchaseOrderService purchaseOrderServiceImplementation;
	
	@Autowired
	private JwtUtils jwtutil;
	
	//add new purchase order
	@PostMapping("purchaseOrders")
	public PurchaseOrder addNewPurchaseOrder(@RequestHeader(value="authorization", defaultValue="")String auth, @RequestBody PurchaseOrder purchaseOrder) throws Exception {
		jwtutil.verify(auth);
		return purchaseOrderServiceImplementation.addNewPurchaseOrder(purchaseOrder);
	}
	
	//update purchase order by id
	@PutMapping("purchaseOrders/{_purchaseOrderId}")
	public PurchaseOrder updatePurchaseOrderById(@RequestHeader(value="authorization", defaultValue="")String auth, @PathVariable Integer _purchaseOrderId, @RequestBody PurchaseOrder _purchaseOrder) throws Exception{
		jwtutil.verify(auth);
		return purchaseOrderServiceImplementation.updatePurchaseOrderById(_purchaseOrderId, _purchaseOrder);
	}
	
	//list all purchase orders
	@GetMapping("purchaseOrders")
	public List<PurchaseOrder> listAllPurchaseOrder(@RequestHeader(value="authorization", defaultValue="")String auth) throws Exception{
		jwtutil.verify(auth);
		return purchaseOrderServiceImplementation.listAllPurchaseOrder();
	}
	
	//delete a purchaseOrder by id
	@DeleteMapping("purchaseOrders/{_purchaseOrderId}")
	public PurchaseOrder deletePurchaseOrderById(@RequestHeader(value="authorization", defaultValue="")String auth, @PathVariable Integer _purchaseOrderId) throws Exception{
		jwtutil.verify(auth);
		return purchaseOrderServiceImplementation.deletePurchaseOrderById(_purchaseOrderId);
	}
	
	//search purchase Order by id
	@GetMapping("purchaseOrders/{_purchaseOrderId}")
	public PurchaseOrder searchPurchaseOrderById(@RequestHeader(value="authorization", defaultValue="")String auth, @PathVariable Integer _purchaseOrderId) throws Exception{
		jwtutil.verify(auth);
		return purchaseOrderServiceImplementation.searchPurchaseOrderById(_purchaseOrderId);
	}
	
//	get assetType name from Asset Definition id
	@GetMapping("purchaseOrderAssets")
	public String getAssetTypeName(@RequestHeader(value="authorization", defaultValue="")String auth, @PathVariable Integer _assetDefinitionId) throws Exception{
		jwtutil.verify(auth);
		return purchaseOrderServiceImplementation.getAssetTypeNameFromAssetDefinitionId(_assetDefinitionId);
	}
	
	//get all purchase status
	@GetMapping("purchaseStatus")
	public List<PurchaseStatus> getAllpurchaseStatus(@RequestHeader(value="authorization", defaultValue="")String auth) throws Exception{
		jwtutil.verify(auth);
		return purchaseOrderServiceImplementation.getAllPurchaseStatus();
	}
}
