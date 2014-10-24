package com.max.practice.model;

import java.io.Serializable;

/**
 * Created by mmukhanov on 02.09.2014.
 */
public class Department implements Serializable {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
