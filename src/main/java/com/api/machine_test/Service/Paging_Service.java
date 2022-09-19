package com.api.machine_test.Service;

import com.api.machine_test.model.Categories_Model;

import java.util.List;

public interface Paging_Service {
    List<Categories_Model> findPaginated(int pageNo, int pageSize);

}

