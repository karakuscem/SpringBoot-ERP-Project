package com.example.erp_system.dto;

import com.example.erp_system.entity.CustomerOrderEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CustomerDTO {
    private UUID uuid;
    private String name;
    private String email;
    public CustomerDTO() {
        this.uuid = UUID.randomUUID();
    }
}
