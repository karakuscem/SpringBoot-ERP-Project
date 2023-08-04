package com.example.erp_system.repository;

import com.example.erp_system.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

// CustomerRepository Jpa Repository'den extend edilmiştir.
// JpaRepository'den extend edilmesi için CustomerEntity ve Long tipinde bir id'ye ihtiyaç vardır.
// silme, bulma gibi işlemler için UUID tipinde bir id'ye ihtiyaç vardır.
@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    List<CustomerEntity> findAllByNameContainsIgnoreCase(String name);

    void deleteByUuid(UUID uuid);

    CustomerEntity findByUuid(UUID uuid);

}
