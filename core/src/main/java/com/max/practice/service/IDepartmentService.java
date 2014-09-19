package com.max.practice.service;

import com.max.practice.model.Department;

import java.util.List;

/**
 * Created by mmukhanov on 02.09.2014.
 */
public interface IDepartmentService {

    List<Department> getAll();

    List<Department> getDepartments(Integer page, Integer pageSize, String sortBy, String sortOrder);

    Integer getDepartmentsCount();

    void addDepartment(Department department);

    void removeDepartment(Long id);

    Department getDepartment(Long id);

    void updateDepartment(Department department);
}
