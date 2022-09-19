package com.api.machine_test.repository;

import com.api.machine_test.model.Categories_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface Categories_Repository extends JpaRepository<Categories_Model,Long> {
}

