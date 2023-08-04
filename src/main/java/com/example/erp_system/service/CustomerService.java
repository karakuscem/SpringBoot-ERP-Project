package com.example.erp_system.service;

import com.example.erp_system.entity.CustomerEntity;
import com.example.erp_system.entity.CustomerOrderEntity;
import com.example.erp_system.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public boolean createCustomer(String name, String email) {
        if (name == null || email == null) {
            return false;
        } else {
            CustomerEntity customerEntity = new CustomerEntity();
            customerEntity.setName(name);
            customerEntity.setEmail(email);
            customerRepository.save(customerEntity);
            return true;
        }
    }

    public List<CustomerEntity> getAll() {
        return customerRepository.findAll();
    }

    public List<CustomerEntity> getAllByNameIContains(String name) {
        return customerRepository.findAllByNameContainsIgnoreCase(name);
    }

    public boolean deleteCustomer(UUID uuid) {
        if (uuid == null)
            return false;
        customerRepository.deleteByUuid(uuid);
        return true;
    }

    public boolean updateCustomer(UUID uuid, CustomerEntity customerEntity) {
        if (uuid == null || customerEntity == null) {
            return false;
        } else {
            CustomerEntity existingCustomer = customerRepository.findByUuid(uuid);
            if (existingCustomer == null)
                return false;
            existingCustomer.setName(customerEntity.getName());
            existingCustomer.setEmail(customerEntity.getEmail());
            customerRepository.save(existingCustomer);
            return true;
        }
    }

}
