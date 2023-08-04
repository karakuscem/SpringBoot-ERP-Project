package com.example.erp_system.repository;

import com.example.erp_system.entity.CustomerOrderEntity;
import com.example.erp_system.util.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

// CustomerOrderRepository Jpa Repository'den extend edilmiştir.
// JpaRepository'den extend edilmesi için CustomerOrderEntity ve Long tipinde bir id'ye ihtiyaç vardır.
// silme, bulma gibi işlemler için UUID tipinde bir id'ye ihtiyaç vardır.
@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrderEntity, Long> {
    void deleteByUuid(UUID uuid);

    CustomerOrderEntity findByUuid(UUID uuid);

    List<CustomerOrderEntity> getCustomerOrderEntitiesByStatus(StatusEnum statusEnum);
}