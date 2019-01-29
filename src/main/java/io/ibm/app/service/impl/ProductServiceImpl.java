package io.ibm.app.service.impl;

import io.ibm.app.model.Product;
import io.ibm.app.repository.IProductRepository;
import io.ibm.app.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;
@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository repository;
    @Override
    public String saveProduct(Product product) {
        product.setCreatedDate(new Date());
        return repository.save(product).getProductId();
    }

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public Product getOneProductById(String productId) {
        try {
            return repository.getOne(productId);
        }catch (EntityNotFoundException e){
            return null;
        }
    }

    @Override
    public void deleteProductById(String productId) {
        repository.delete(productId);

    }
    @Override
    public void updateProduct(Product product) {
        product.setCreatedDate(repository.getOne(product.getProductId()).getCreatedDate());
        product.setLastModifiedDate(new Date());
        repository.save(product);
    }
}
