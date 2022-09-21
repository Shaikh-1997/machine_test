package com.api.machine_test.repository;

import com.api.machine_test.dto.One_to_Many_Response;
import com.api.machine_test.model.Categories_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface Categories_Repository extends JpaRepository<Categories_Model,Long> {
    @Query("Select new com.api.machine_test.dto.One_to_Many_Response( c.category_id, p.id) from categories c join c.products p")
    public List<One_to_Many_Response> getAssociation();
}

