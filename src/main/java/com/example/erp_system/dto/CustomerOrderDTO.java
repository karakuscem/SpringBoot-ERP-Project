package com.example.erp_system.dto;

import com.example.erp_system.util.StatusEnum;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CustomerOrderDTO {
    private UUID uuid;
    private CustomerDTO customer;
    private List<ProductDTO> productList = new ArrayList<>();
    private StatusEnum status = StatusEnum.WAITING;
    private BigDecimal totalPrice;
    public CustomerOrderDTO() {
        this.uuid = UUID.randomUUID();
    }
}
