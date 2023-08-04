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

/*{
    "name":"Krem",
    "isKdvApplied":true,
    "price":31,
    "nonKdvAppliedPrice": 21,
    "stock":69,
    "kdv":{"name":"gecirme", "percent":15},
    "order":{}
}
        "id": 1,
        "uuid": "c4457154-33f9-401a-bdf7-2ed76037f9fa",
        "creationDate": "2023-08-03T21:13:34.006+00:00",
        "updatedDate": "2023-08-04T08:20:04.462+00:00",
        "name": "Cexm",
        "email": "karakuscem@gmail.com",
        "orderList": []
 */