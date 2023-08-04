package com.example.erp_system.repository;

import com.example.erp_system.entity.KdvEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

// KdvRepository Jpa Repository'den extend edilmiştir.
// JpaRepository'den extend edilmesi için KdvEntity ve Long tipinde bir id'ye ihtiyaç vardır.
// silme, bulma gibi işlemler için UUID tipinde bir id'ye ihtiyaç vardır.
@Repository
public interface KdvRepository extends JpaRepository<KdvEntity, Long> {
    List<KdvEntity> findAllByNameContainsIgnoreCase(String name);

    void deleteByUuid(UUID uuid);

    KdvEntity findByUuid(UUID uuid);

}
