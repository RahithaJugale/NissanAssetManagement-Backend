package com.nissan.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.nissan.model.PurchaseStatus;

@Repository
public interface IPurchaseStatusRepository extends JpaRepositoryImplementation<PurchaseStatus, Integer> {

}
