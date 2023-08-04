package com.example.erp_system.controller;

import com.example.erp_system.entity.CustomerOrderEntity;
import com.example.erp_system.service.CustomerOrderService;
import com.example.erp_system.util.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("customerOrder")
public class CustomerOrderController {
    @Autowired
    CustomerOrderService customerOrderService;

    @GetMapping
    public ResponseEntity<List<CustomerOrderEntity>> getAll() {
        return new ResponseEntity<>(customerOrderService.getAll(), HttpStatus.OK);
    }

    @GetMapping("get/{uuid}")
    public ResponseEntity<CustomerOrderEntity> getByUuid(@PathVariable UUID uuid) {
        return new ResponseEntity<>(customerOrderService.getByUuid(uuid), HttpStatus.OK);
    }

    @GetMapping("getByStatus/{status}")
    public ResponseEntity<List<CustomerOrderEntity>> getByStatus(@PathVariable String status) {
        return new ResponseEntity<>(customerOrderService.getByStatus(StatusEnum.fromString(status)), HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<Boolean> createCustomerOrder(@RequestBody CustomerOrderEntity customerOrder) {
        return new ResponseEntity<>(customerOrderService.createCustomerOrder(customerOrder.getCustomer(),
                customerOrder.getProductList()), HttpStatus.CREATED);
    }

    @PutMapping("update/{uuid}")
    public ResponseEntity<Boolean> updateCustomerOrder(@PathVariable UUID uuid, @RequestBody CustomerOrderEntity customerOrder) {
        return new ResponseEntity<>(customerOrderService.updateCustomerOrderEntity(uuid, customerOrder), HttpStatus.OK);
    }

    @DeleteMapping("delete/{uuid}")
    public ResponseEntity<Boolean> deleteCustomerOrder(@PathVariable UUID uuid) {
        return new ResponseEntity<>(customerOrderService.deleteCustomerOrderEntity(uuid), HttpStatus.OK);
    }

    @PostMapping("add/{orderuuid}/{productuuid}")
    public ResponseEntity<Boolean> addProductToCustomerOrder(@PathVariable UUID orderuuid,
                                                             @PathVariable UUID productuuid)
    {

        return new ResponseEntity<>(customerOrderService.addProductToCustomerOrder(orderuuid, productuuid), HttpStatus.OK);
    }

    @PostMapping("approve/{customerOrderUuid}")
    public ResponseEntity<CustomerOrderEntity> approveCustomerOrder(@PathVariable UUID customerOrderUuid) {
        return new ResponseEntity<>(customerOrderService.controlOrderStatus(customerOrderUuid)
                , HttpStatus.OK);
    }
}

/*
ba70f1a0-4d39-4455-b32d-61bc100fdfd2
757bc07a-b702-4e13-ac8a-4adfe444fe36
 */