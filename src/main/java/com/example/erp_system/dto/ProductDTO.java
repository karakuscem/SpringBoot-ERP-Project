package com.example.erp_system.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class ProductDTO {
    private UUID uuid;
    private String name;
    private Boolean isKdvApplied;
    private BigDecimal price;
    private BigDecimal nonKdvAppliedPrice = BigDecimal.ZERO;
    private Integer stock;
    private KdvDTO kdv;
    private CustomerOrderDTO order;
    private int orderCount;

    public ProductDTO() {
        this.uuid = UUID.randomUUID();
    }
}
