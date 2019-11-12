package com.ea.product.service;

import com.ea.product.entity.Product;
import com.ea.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product addProduct(Product product) throws Exception {
        if (product == null) {
            throw new Exception("Product not found");
        }

        Product product1 = repository.findByNameAndCategoryId(product.getName(), product.getCategoryId());
        if (product1 != null) {
            throw new Exception("Product is already registered by this name");
        }

        return repository.save(product);
    }

    public Product updateProduct(Long id, Product product) throws Exception {
        Product product1 = findById(id);

        if (product1 == null) {
            throw new Exception("Product not found");
        }

        product1.setName(product.getName());
        product1.setDesc(product.getDesc());
        product1.setPrice(product.getPrice());

        repository.save(product1);
        return product1;

    }


    public Product findById(Long id) {
        return repository.findById(id).get();
    }


    public Product deleteProduct(Long id) throws Exception {
        Product product = findById(id);

        if (product == null) {
            throw new Exception("Product not found");
        }

        repository.delete(product);
        return product;

    }

    public List<Product> getAllProducts() {
        return repository.findAll();

    }

    public List<Product> getProductsByCategory(Long catId) {
        return repository.findAllByCategoryId(catId);
    }


}




