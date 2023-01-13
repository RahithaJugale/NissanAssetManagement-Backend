package com.nissan.service;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.model.AssetMaster;
import com.nissan.model.PurchaseOrder;
import com.nissan.model.PurchaseStatus;
import com.nissan.repo.IPurchaseOrderRepository;
import com.nissan.repo.IPurchaseStatusRepository;

@Service
public class PurchaseOrderServiceImplementation implements IPurchaseOrderService {

	@Autowired
	IPurchaseOrderRepository purchaseOrderRepository;

	@Autowired
	IAssetMasterService assetMasterServiceImplementation;

	@Autowired
	IPurchaseStatusRepository purchaseStatusRepository;

	// add new purchase order
	@Override
	@Transactional
	public PurchaseOrder addNewPurchaseOrder(PurchaseOrder purchaseOrder) {
		try {
			if (((new SimpleDateFormat("dd/MM/yyyy").parse(purchaseOrder.getDeliveryDate()))
					.compareTo(new SimpleDateFormat("dd/MM/yyyy").parse(purchaseOrder.getOrderDate())) > 0)) {
				purchaseOrderRepository.save(purchaseOrder);
				if (purchaseOrder.getStatusId() == 4) {
					AssetMaster assetMaster = new AssetMaster();
					assetMaster.setAssetDefinitionId(purchaseOrder.getAssetDefinitionId());
					assetMaster.setAssetTypeId(purchaseOrder.getAssetTypeId());
					assetMaster.setVendorId(purchaseOrder.getVendorId());
					assetMaster.setPurchaseDate(purchaseOrder.getOrderDate());
					assetMaster.setIsActive(true);
					assetMasterServiceImplementation.addNewAssetMaster(assetMaster);
				}
				return purchaseOrder;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	// update purchase order by id
	@Override
	@Transactional
	public PurchaseOrder updatePurchaseOrderById(Integer _purchaseOrderId, PurchaseOrder _purchaseOrder) {
		try {
			
				PurchaseOrder purchaseOrder = purchaseOrderRepository.findById(_purchaseOrderId).get();
				purchaseOrder.setPurchaseOrderNo(_purchaseOrder.getPurchaseOrderNo());
				purchaseOrder.setAssetDefinitionId(_purchaseOrder.getAssetDefinitionId());
				purchaseOrder.setAssetTypeId(_purchaseOrder.getAssetTypeId());
				purchaseOrder.setQuantity(_purchaseOrder.getQuantity());
				purchaseOrder.setVendorId(_purchaseOrder.getVendorId());
				purchaseOrder.setOrderDate(_purchaseOrder.getOrderDate());
				purchaseOrder.setIsActive(_purchaseOrder.getIsActive());
				purchaseOrder.setStatusId(_purchaseOrder.getStatusId());
				if (((new SimpleDateFormat("dd/MM/yyyy").parse(purchaseOrder.getDeliveryDate()))
						.compareTo(new SimpleDateFormat("dd/MM/yyyy").parse(purchaseOrder.getOrderDate())) > 0)) {
				return purchaseOrderRepository.save(purchaseOrder);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
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

	// get all purchase status
	@Override
	public List<PurchaseStatus> getAllPurchaseStatus() {
		return purchaseStatusRepository.findAll();
	}

	// get assetType name from Asset Definition Id
	@Override
	public String getAssetTypeNameFromAssetDefinitionId(Integer _assetDefinitionId) {
		return purchaseOrderRepository.getAssetTypeNameFromAssetDefinitionId(_assetDefinitionId);
	}

}
