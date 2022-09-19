package com.api.machine_test.model;

import javax.persistence.*;

@Entity
@Table(name="products")
public class Products_Model {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String product_name;
    private int amount;
    private int  category_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "Products_Model{" +
                "id=" + id +
                ", product_name='" + product_name + '\'' +
                ", amount=" + amount +
                ", category_id=" + category_id +
                '}';
    }
}
