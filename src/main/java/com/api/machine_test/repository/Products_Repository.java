package com.api.machine_test.repository;

import com.api.machine_test.model.Products_Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Products_Repository extends JpaRepository<Products_Model, Integer> {
}
