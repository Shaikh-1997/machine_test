package com.api.machine_test.dto;

import com.api.machine_test.model.Categories_Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Product_Req {
    private Categories_Model categories_model;
}
