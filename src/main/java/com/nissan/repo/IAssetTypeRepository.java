package com.nissan.repo;

import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nissan.model.AssetType;

@Repository
public interface IAssetTypeRepository extends JpaRepositoryImplementation<AssetType, Integer> {
	
	@Query("from AssetType where typeName LIKE ?1")
	public AssetType getAssetTypeByName(String _typeName);
	
	@Procedure("sp_insert_update_asset_type")
	public void insertOrUpdateAssetType(@Param("asset_type_id")Integer assetTypeId, @Param("type_name") String typeName, @Param("is_active")Boolean isActive);

}
