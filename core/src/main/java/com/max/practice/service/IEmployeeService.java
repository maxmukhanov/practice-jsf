package com.max.practice.service;

import com.max.practice.model.Employee;

import java.util.List;

/**
 * Created by mmukhanov on 03.09.2014.
 */
public interface IEmployeeService {

    List<Employee> getEmployees(Long departmentId);

    Employee getEmployee(Long employeeId);

    void addEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void removeEmployee(Long employeeId);

}
