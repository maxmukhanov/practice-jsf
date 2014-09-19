package com.max.practice.service.impl;

import com.max.practice.model.Department;
import com.max.practice.service.IDepartmentService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DepartmentService implements IDepartmentService, InitializingBean {

    private static long COUNTER = 1L;
    private Map<Long, Department> departmentMap = new LinkedHashMap<Long, Department>();

    @Override
    public List<Department> getAll() {
        return new ArrayList<Department>(departmentMap.values());
    }

    @Override
    public List<Department> getDepartments(Integer page, Integer pageSize, String sortBy, String sortOrder) {

        Collection<Department> values = departmentMap.values();
        ArrayList<Department> departments = new ArrayList<Department>();

        Integer start = (page - 1) * pageSize;
        Integer end = start + pageSize;

        if (values.size() >= start) {
            int i = 0;
            for (Department value : values) {
                if (i >= start) {
                    if (i < end) {
                        departments.add(value);
                    } else {
                        break;
                    }
                }

                i++;
            }
        }

        return departments;
    }

    @Override
    public Integer getDepartmentsCount() {
        return departmentMap.size();
    }

    @Override
    public void addDepartment(Department department) {
        department.setId(generateId());

        addToDepartmentMap(department);
    }

    @Override
    public void removeDepartment(Long id) {
        departmentMap.remove(id);
    }

    @Override
    public Department getDepartment(Long id) {
        return departmentMap.get(id);
    }

    @Override
    public void updateDepartment(Department department) {
        addToDepartmentMap(department);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        addToDepartmentMap(createDepartment("Luxoft"));
        addToDepartmentMap(createDepartment("EPAM"));
        addToDepartmentMap(createDepartment("Global"));
        addToDepartmentMap(createDepartment("Ciklum"));
        addToDepartmentMap(createDepartment("AimProSoft"));
    }

    private void addToDepartmentMap(Department department) {
        departmentMap.put(department.getId(), department);
    }

    private Department createDepartment(String name) {
        Long id = generateId();

        Department department = new Department();
        department.setId(id);
        department.setName(name);

        return department;
    }

    private Long generateId() {
        return COUNTER++;
    }
}
