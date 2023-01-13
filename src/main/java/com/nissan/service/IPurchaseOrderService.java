package com.nissan.service;

import java.util.List;

import com.nissan.model.PurchaseOrder;
import com.nissan.model.PurchaseStatus;

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
	
	//get assetType name from Asset Definition Id
	String getAssetTypeNameFromAssetDefinitionId(Integer _assetDefinitionId);
	
	//get purchase status
	List<PurchaseStatus> getAllPurchaseStatus();
}
