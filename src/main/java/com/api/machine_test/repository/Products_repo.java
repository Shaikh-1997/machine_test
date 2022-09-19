package com.api.machine_test.repository;

import com.api.machine_test.model.Categories_Model;
import com.api.machine_test.model.Products_Model;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface Products_repo extends PagingAndSortingRepository<Products_Model, Long> {


}
