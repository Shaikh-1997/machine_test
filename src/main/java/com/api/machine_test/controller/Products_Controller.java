package com.api.machine_test.controller;

import com.api.machine_test.Service.Prod_Service;
import com.api.machine_test.Service.Products_Paging_Service;
import com.api.machine_test.Service.Products_Paging_Service_Impl;
import com.api.machine_test.exception.ResourceNotFound;
import com.api.machine_test.model.Categories_Model;
import com.api.machine_test.model.Products_Model;
import com.api.machine_test.repository.Products_Repository;
import com.api.machine_test.repository.Products_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/")

public class Products_Controller {
    @Autowired
    Products_Repository products_repository;
    @Autowired
    Products_repo products_repo;
    @Autowired
    Products_Paging_Service products_paging_service;
    @Autowired
    Products_Paging_Service_Impl products_paging_service_impl;
    @Autowired
    Prod_Service prod_service;

    @GetMapping("/products")
    public List<Products_Model> getAllProducts() {
        return products_repository.findAll();
    }

    @GetMapping("/products/{page}")
    public List<Products_Model> getPaginatedProducts(@PathVariable (value ="page")int pageNo, Products_Model products_model){
        int pageSize=3;

        return products_paging_service

                .findPaginate(pageNo, pageSize);
    }

    @PostMapping("/products")
    public String addProducts(@RequestBody Products_Model products_model, @RequestBody Categories_Model categories_model) throws SQLException {
        boolean get;
        get = prod_service.checklCategories(categories_model, products_model);
        if (get == true) {
            return "product Add sucessfullly";
        } else {
            return "Invalid Category_id";
        }

    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Products_Model> getProductById(@PathVariable long id) {
        Products_Model products_model = products_repository.findById((int) id).orElseThrow(() -> new ResourceNotFound("Category not found!!!"));
        return ResponseEntity.ok(products_model);

    }
    @PutMapping("/products/{id}")

    public ResponseEntity<Products_Model> updateProducts(@PathVariable long id, @RequestBody Products_Model update_products_model){
        Products_Model products_model= products_repository.findById((int) id).orElseThrow(()->new ResourceNotFound("Category not found!!!"));
        products_model.setProduct_name(update_products_model.getProduct_name());
        products_model.setCategory_id(update_products_model.getCategory_id());
        products_model.setAmount(update_products_model.getAmount());

        products_repository.save(products_model);
        return ResponseEntity.ok(products_model);
    }


    @DeleteMapping("/products/{id}")
    public ResponseEntity<HttpStatus> deleteProducts(@PathVariable long id, @RequestBody Products_Model delete_products_model){
        Products_Model products_model= products_repository.findById((int) id).orElseThrow(()->new ResourceNotFound("Category not found!!!"));
        products_repository.delete(products_model);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }
}
