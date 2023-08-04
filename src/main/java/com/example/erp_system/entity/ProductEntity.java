package com.example.erp_system.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table
@Data
@AttributeOverride(name = "uuid", column = @Column(name = "product_uuid"))
public class ProductEntity extends BaseEntity{
    @Column
    private String name;
    @Column
    private Boolean isKdvApplied;
    @Column
    private BigDecimal price;
    @Column
    private BigDecimal nonKdvAppliedPrice = BigDecimal.ZERO;
    @Column
    private Integer stock;
    @Column
    private int orderCount;
    @ManyToOne
    @JoinColumn(name = "kdv_id", unique = false)
    private KdvEntity kdv;

}
