package com.ea.product.repository;

import com.ea.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByNameAndCategoryId(String name, Long catId);


    List<Product> findAllByCategoryId(Long catId);
}
