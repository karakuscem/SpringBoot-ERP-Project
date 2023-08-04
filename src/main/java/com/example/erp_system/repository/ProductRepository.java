package com.example.erp_system.repository;

import com.example.erp_system.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

// ProductRepository Jpa Repository'den extend edilmiştir.
// JpaRepository'den extend edilmesi için ProductEntity ve Long tipinde bir id'ye ihtiyaç vardır.
// silme, bulma gibi işlemler için UUID tipinde bir id'ye ihtiyaç vardır.
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    void deleteByUuid(UUID uuid);

    ProductEntity findByUuid(UUID uuid);

    List<ProductEntity> findAllByNameContainsIgnoreCase(String name);


}
