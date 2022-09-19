package com.api.machine_test.controller;


import com.api.machine_test.Service.Paging_Service;
import com.api.machine_test.Service.Paging_Service_Impl;
import com.api.machine_test.exception.ResourceNotFound;
import com.api.machine_test.model.Categories_Model;
import com.api.machine_test.repository.Categories_Repo;
import com.api.machine_test.repository.Categories_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class Categories_Controller {



@Autowired
private Categories_Repository categories_repository;
@Autowired
private Categories_Repo categories_repo;
@Autowired
    Paging_Service paging_service;

  @GetMapping("/categories")
  public List<Categories_Model> getAllCategories(){
      return categories_repository.findAll();
   }


    @GetMapping("/categories/{page}")
    public List<Categories_Model> getPaginatedCaregories(@PathVariable (value ="page")int pageNo, Categories_Model categories_model){
                     int pageSize=3;

        return paging_service.findPaginated(pageNo, pageSize);
    }


/*  @GetMapping("/categories/{page}")
    public List<Categories_Model> findPaginated(@PathVariable(value ="pageNo") int pageNo, Categories_Model categories_model){
        int pageSize=4;
        Page <Categories_Model> page=category_service.findPaginated(pageNo,pageSize);
        List<Categories_Model> listCategories = page.getContent();
        return categories_repository.findAll();
    }*/
    @PostMapping("/categories")
    public Categories_Model create(@RequestBody Categories_Model categories_model){
        return categories_repository.save(categories_model);
    }

    @GetMapping("/categories/{category_id}")
    public ResponseEntity<Categories_Model> getCategoryById(@PathVariable long category_id) {
     Categories_Model categories_model=categories_repository.findById(category_id).orElseThrow(()->new ResourceNotFound("Category not found!!!"));
     return ResponseEntity.ok(categories_model);
  }

  @PutMapping("/categories/{category_id}")

      public ResponseEntity<Categories_Model> updateCategory(@PathVariable long category_id, @RequestBody Categories_Model update_categories_model){
      Categories_Model categories_model= categories_repository.findById(category_id).orElseThrow(()->new ResourceNotFound("Category not found!!!"));
      categories_model.setCategory_name(update_categories_model.getCategory_name());
      categories_repository.save(categories_model);
      return ResponseEntity.ok(categories_model);
    }


    @DeleteMapping("/categories/{category_id}")
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable long category_id,@RequestBody Categories_Model delete_categories_model){
        Categories_Model categories_model= categories_repository.findById(category_id).orElseThrow(()->new ResourceNotFound("Category not found!!!"));
        categories_repository.delete(categories_model);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }
}

