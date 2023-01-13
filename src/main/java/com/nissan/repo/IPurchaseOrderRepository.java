package com.nissan.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.nissan.model.PurchaseOrder;

@Repository
public interface IPurchaseOrderRepository extends JpaRepositoryImplementation<PurchaseOrder, Integer> {
	
	@Query(value="{call sp_get_asset_type_name(:_assetDefinitionId)}", nativeQuery=true)
	public String getAssetTypeNameFromAssetDefinitionId(Integer _assetDefinitionId); 

}
