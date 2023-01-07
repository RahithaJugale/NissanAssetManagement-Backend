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

import com.nissan.model.PurchaseOrder;
import com.nissan.service.IPurchaseOrderService;

@RestController
@RequestMapping("api/")
public class PurchaseOrderController {

	@Autowired
	IPurchaseOrderService purchaseOrderServiceImplementation;
	
	//add new purchase order
	@PostMapping("purchaseOrders")
	public PurchaseOrder addNewPurchaseOrder(@RequestBody PurchaseOrder purchaseOrder) {
		return purchaseOrderServiceImplementation.addNewPurchaseOrder(purchaseOrder);
	}
	
	//update purchase order by id
	@PutMapping("purchaseOrders/{_purchaseOrderId}")
	public PurchaseOrder updatePurchaseOrderById(@PathVariable Integer _purchaseOrderId, @RequestBody PurchaseOrder _purchaseOrder) {
		return purchaseOrderServiceImplementation.updatePurchaseOrderById(_purchaseOrderId, _purchaseOrder);
	}
	
	//list all purchase orders
	@GetMapping("purchaseOrders")
	public List<PurchaseOrder> listAllPurchaseOrder() {
		return purchaseOrderServiceImplementation.listAllPurchaseOrder();
	}
	
	//delete a purchaseOrder by id
	@DeleteMapping("purchaseOrders/{_purchaseOrderId}")
	public PurchaseOrder deletePurchaseOrderById(@PathVariable Integer _purchaseOrderId) {
		return purchaseOrderServiceImplementation.deletePurchaseOrderById(_purchaseOrderId);
	}
	
	//search purchase Order by id
	@GetMapping("purchaseOrders/{_purchaseOrderId}")
	public PurchaseOrder searchPurchaseOrderById(@PathVariable Integer _purchaseOrderId) {
		return purchaseOrderServiceImplementation.searchPurchaseOrderById(_purchaseOrderId);
	}
}
