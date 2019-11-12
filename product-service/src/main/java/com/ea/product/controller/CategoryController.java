package com.ea.product.controller;

import com.ea.product.entity.Category;
import com.ea.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/")
    public Category createCategory(@RequestBody Category category) throws Exception {
        return categoryService.createCategory(category);
    }

    @PatchMapping("/{id}")
    public Category updateCategory(@RequestBody Category category, @PathVariable("id") Long id) throws Exception {
        return categoryService.updateCategory(category, id);
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable("id") Long id) {
        return categoryService.getById(id);
    }

    @DeleteMapping("/{id}")
    public Category deleteCategory(@PathVariable("id") Long id) throws Exception {
        return categoryService.deleteCategory(id);
    }


}
