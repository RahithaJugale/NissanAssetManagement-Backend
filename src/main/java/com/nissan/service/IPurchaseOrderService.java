package com.nissan.service;

import java.util.List;

import com.nissan.model.PurchaseOrder;

public interface IPurchaseOrderService {
	
	//add new purchase order
	PurchaseOrder addNewPurchaseOrder(PurchaseOrder purchaseOrder);
	
	//update purchase order by id
	PurchaseOrder updatePurchaseOrderById(Integer _purchaseOrderId, PurchaseOrder purchaseOrder);
	
	//list all purchase orders
	List<PurchaseOrder> listAllPurchaseOrder();
	
	//delete a purchaseOrder by id
	PurchaseOrder deletePurchaseOrderById(Integer _purchaseOrderId);
	
	//search purchase Order by id
	PurchaseOrder searchPurchaseOrderById(Integer _purchaseOrderId);
}
