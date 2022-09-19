package com.api.machine_test.repository;

import com.api.machine_test.model.Categories_Model;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Categories_Repo extends PagingAndSortingRepository<Categories_Model, Long> {

}
