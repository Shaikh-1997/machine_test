package com.api.machine_test.Service;

import com.api.machine_test.model.Categories_Model;
import com.api.machine_test.model.Products_Model;
import com.api.machine_test.repository.Products_Repository;
import com.api.machine_test.repository.Products_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class Products_Paging_Service_Impl implements  Products_Paging_Service{



    @Autowired
    private Products_Repository products_repository;
    @Autowired

    private Products_repo products_repo;
    @Autowired
    Products_Model products_model;

    @Override
    public List<Products_Model> findPaginate(int pageNo, int pageSize) {

        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Products_Model> pagedResult = products_repo.findAll(paging);

        return pagedResult.toList();
    }
}