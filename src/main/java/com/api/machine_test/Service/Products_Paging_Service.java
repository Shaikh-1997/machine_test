package com.api.machine_test.Service;

import com.api.machine_test.model.Categories_Model;
import com.api.machine_test.model.Products_Model;

import java.util.List;

public interface Products_Paging_Service {
    List<Products_Model> findPaginate(int pageNo, int pageSize);

}
