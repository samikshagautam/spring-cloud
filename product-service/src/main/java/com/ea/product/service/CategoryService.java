package com.ea.product.service;

import com.ea.product.entity.Category;
import com.ea.product.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(Category category) throws Exception {
        Category category1 = categoryRepository.findByName(category.getName());
        if (category1 != null) {
            throw new Exception("Category name is already taken!");
        }

        return categoryRepository.save(category);
    }

    public Category updateCategory(Category category, Long id) throws Exception {
        Category category1 = getById(id);

        if (category1 == null) {
            throw new Exception("Category not found");
        }

        category1.setName(category.getName());
        return categoryRepository.save(category1);

    }

    public Category getById(Long id) {
        return categoryRepository.findById(id).get();
    }

    public Category deleteCategory(Long id) throws Exception {
        Category category = getById(id);
        if (category == null) {
            throw new Exception("Category not found");
        }

        categoryRepository.delete(category);
        return category;
    }
}
