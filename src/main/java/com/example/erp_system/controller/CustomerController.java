package com.example.erp_system.controller;

import com.example.erp_system.dto.CustomerDTO;
import com.example.erp_system.entity.CustomerEntity;
import com.example.erp_system.service.CustomerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

// CustomerController customer ile alakalı istekleri karşılar. CustomerService ile iletişim kurar.
// Customer ile alakalı her istek buradan geçer. Burada silme, güncelleme, ekleme, listeleme gibi işlemler yapılır.
@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerEntity>> getAll() {
        return new ResponseEntity<>(customerService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<CustomerEntity>> getAllByName(@PathVariable String name) {
        return new ResponseEntity<>(customerService.getAllByNameIContains(name), HttpStatus.OK);
    }

    @Modifying
    @Transactional
    @PutMapping("update/{uuid}")
    public ResponseEntity<Boolean> updateCustomerByUuid(@PathVariable UUID uuid, @RequestBody CustomerDTO customer) {
        CustomerEntity newCustomer = new CustomerEntity();
        newCustomer.setEmail(customer.getEmail());
        newCustomer.setName(customer.getName());
        return new ResponseEntity<>(customerService.updateCustomer(uuid, newCustomer), HttpStatus.OK);
    }

    @Modifying
    @Transactional
    @DeleteMapping("delete/{uuid}")
    public ResponseEntity<Boolean> deleteCustomerByUuid(@PathVariable UUID uuid) {
        return new ResponseEntity<>(customerService.deleteCustomer(uuid), HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<Boolean> createCustomer(@RequestBody CustomerDTO customer) {
        return new ResponseEntity<>(customerService.createCustomer(customer.getName(), customer.getEmail()),
                HttpStatus.CREATED);
    }

}
