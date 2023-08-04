package com.example.erp_system.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

// CustomerEntity database için bir tablodur. Bu tablo BaseEntity sınıfından türetilmiştir.
@Entity
@Table
@Data
@AttributeOverride(name = "uuid", column = @Column(name = "customer_uuid"))
public class CustomerEntity extends BaseEntity{
    @Column
    private String name;
    @Column
    private String email;

}
