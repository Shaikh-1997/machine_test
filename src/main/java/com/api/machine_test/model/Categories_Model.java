package com.api.machine_test.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Categories")

public class Categories_Model implements Serializable {
    @Override
    public String toString() {
        return "Categories_Model{" +
                "category_id=" + category_id +
                ", category_name='" + category_name + '\'' +
                '}';
    }

    public long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(long category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @JsonProperty
    private long category_id;
    @JsonProperty

    private String category_name;

    @OneToMany(targetEntity = Products_Model.class, cascade = CascadeType.ALL)
    @JoinColumn(name="cp_fk",referencedColumnName = "category_id")

    private List<Products_Model> products_modelList;

}
