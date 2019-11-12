package com.ea.product.controller;

import com.ea.product.entity.Product;
import com.ea.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public Product findById(@PathVariable("id") Long id) {
        return productService.findById(id);
    }


    @PostMapping("/")
    public Product addProduct(@RequestBody Product product) throws Exception {
        return productService.addProduct(product);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, Product product) throws Exception {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public Product deleteProduct(@PathVariable("id") Long id) throws Exception {
        return productService.deleteProduct(id);
    }

    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/category/{id}")
    public List<Product> getProductsByCategory(@PathVariable("id") Long id) {
        return productService.getProductsByCategory(id);
    }
}
