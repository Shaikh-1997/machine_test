package com.api.machine_test.Service;

import com.api.machine_test.model.Categories_Model;
import com.api.machine_test.repository.Categories_Repo;
import com.api.machine_test.repository.Categories_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class Paging_Service_Impl  implements  Paging_Service{
    @Autowired
    private Categories_Repository   categories_repository;
    private Categories_Repo categories_repo;

    @Override
    public List<Categories_Model> findPaginated(int pageNo, int pageSize) {

        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Categories_Model> pagedResult = categories_repo.findAll(paging);

        return pagedResult.toList();
    }
}

