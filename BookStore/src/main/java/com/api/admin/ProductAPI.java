package com.api.admin;

import com.model.Category;
import com.service.CategoryService;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductAPI {
//    @Autowired
//    private ProductService productService;
//
//    @GetMapping("/getAll")
//    public ResponseEntity<List<Category>> getAll(){
//        return ResponseEntity.ok(categoryService.getAll());
//    }
}