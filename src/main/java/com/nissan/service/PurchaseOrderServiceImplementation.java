package com.nissan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.nissan.model.AssetMaster;
import com.nissan.model.PurchaseOrder;
import com.nissan.repo.IPurchaseOrderRepository;

public class PurchaseOrderServiceImplementation implements IPurchaseOrderService {

	@Autowired
	IPurchaseOrderRepository purchaseOrderRepository;

	@Autowired
	IAssetMasterService assetMasterServiceImplementation;

	// add new purchase order
	@Override
	@Transactional
	public PurchaseOrder addNewPurchaseOrder(PurchaseOrder purchaseOrder) {
		purchaseOrderRepository.save(purchaseOrder);
		if (purchaseOrder.getStatusId() == 4) {
			AssetMaster assetMaster = new AssetMaster();
			assetMaster.setAssetDefinitionId(purchaseOrder.getAssetDefinitionId());
			assetMaster.setAssetTypeId(purchaseOrder.getAssetTypeId());
			assetMaster.setVendorId(purchaseOrder.getVendorId());
			assetMaster.setWarranty(false);
			assetMasterServiceImplementation.addNewAssetMaster(assetMaster);
		}
		return purchaseOrder;
	}

	// update purchase order by id
	@Override
	@Transactional
	public PurchaseOrder updatePurchaseOrderById(Integer _purchaseOrderId, PurchaseOrder _purchaseOrder) {
		PurchaseOrder purchaseOrder = purchaseOrderRepository.findById(_purchaseOrderId).get();
		purchaseOrder.setPurchaseOrderNo(_purchaseOrder.getPurchaseOrderNo());
		purchaseOrder.setAssetDefinitionId(_purchaseOrder.getAssetDefinitionId());
		purchaseOrder.setAssetTypeId(_purchaseOrder.getAssetTypeId());
		purchaseOrder.setQuantity(_purchaseOrder.getQuantity());
		purchaseOrder.setVendorId(_purchaseOrder.getVendorId());
		purchaseOrder.setOrderDate(_purchaseOrder.getOrderDate());
		purchaseOrder.setIsActive(_purchaseOrder.getIsActive());
		return purchaseOrderRepository.save(purchaseOrder);
	}

	// list all purchase orders
	@Override
	public List<PurchaseOrder> listAllPurchaseOrder() {
		return purchaseOrderRepository.findAll();
	}

	// delete a purchaseOrder by id
	@Override
	@Transactional
	public PurchaseOrder deletePurchaseOrderById(Integer _purchaseOrderId) {
		PurchaseOrder purchaseOrder = purchaseOrderRepository.findById(_purchaseOrderId).get();
		purchaseOrder.setIsActive(false);
		return purchaseOrderRepository.save(purchaseOrder);
	}

	// search purchase Order by id
	@Override
	public PurchaseOrder searchPurchaseOrderById(Integer _purchaseOrderId) {
		return purchaseOrderRepository.findById(_purchaseOrderId).get();
	}

}
