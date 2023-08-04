package com.example.erp_system.service;

import com.example.erp_system.entity.CustomerOrderEntity;
import com.example.erp_system.entity.KdvEntity;
import com.example.erp_system.entity.ProductEntity;
import com.example.erp_system.repository.KdvRepository;
import com.example.erp_system.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

// Product ile ilgili işlemlerin yapıldığı servis sınıfı
// yaratma ve listelemeye yönelik metodlar bulunuyor
@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    KdvRepository kdvRepository;

    public boolean createProduct(String name, boolean isKdvApplied, BigDecimal price,Integer stock, KdvEntity kdv) {
        if (name == null || price == null || stock == null || kdv == null) {
            return false;
        } else {
            ProductEntity productEntity = new ProductEntity();
            productEntity.setName(name);
            productEntity.setIsKdvApplied(isKdvApplied);
            productEntity.setPrice(price);
            productEntity.setStock(stock);
            productEntity.setKdv(kdvRepository.findByUuid(kdv.getUuid()));
            productEntity.setOrderCount(1);
            kdvTruePrice(productEntity);
            productRepository.save(productEntity);
            return true;
        }
    }

    public boolean updateProduct(UUID uuid, ProductEntity productEntity) {
        if (productEntity == null)
            return false;
        else {
            ProductEntity existingProduct = productRepository.findByUuid(uuid);
            if (existingProduct == null)
                return false;
            existingProduct.setName(productEntity.getName());
            existingProduct.setIsKdvApplied(productEntity.getIsKdvApplied());
            existingProduct.setPrice(productEntity.getPrice());
            existingProduct.setNonKdvAppliedPrice(productEntity.getNonKdvAppliedPrice());
            existingProduct.setStock(productEntity.getStock());
            existingProduct.setKdv(productEntity.getKdv());
            kdvTruePrice(existingProduct);
            productRepository.save(existingProduct);
            return true;
        }
    }

    public List<ProductEntity> getAll() {
        return productRepository.findAll();
    }

    public boolean deleteProduct(UUID uuid) {
        if (uuid == null)
            return false;
        else {
            productRepository.deleteByUuid(uuid);
            return true;
        }
    }

    public ProductEntity getByUuid(UUID uuid) {
        return productRepository.findByUuid(uuid);
    }

    public List<ProductEntity> getAllByNameContainsIgnoreCase(String name) {
        return productRepository.findAllByNameContainsIgnoreCase(name);
    }

    public void kdvTruePrice(ProductEntity product) {
        BigDecimal kdv = product.getKdv().getPercent();
        BigDecimal price = product.getPrice();
        if (!product.getIsKdvApplied()) {
            product.setNonKdvAppliedPrice(price);
            BigDecimal kdvPrice = (price.multiply(kdv)).divide(new BigDecimal(100));
            BigDecimal totalPrice = price.add(kdvPrice);
            product.setPrice(totalPrice);
        } else {
            BigDecimal kdvPrice = price.multiply(kdv.divide(BigDecimal.valueOf(100)));
            BigDecimal nonKdvPrice = price.subtract(kdvPrice);
            product.setNonKdvAppliedPrice(nonKdvPrice);
        }
    }

}
