package com.max.practice.service.impl;

import com.max.practice.model.Employee;
import com.max.practice.service.IEmployeeService;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by mmukhanov on 03.09.2014.
 */
@Service
public class EmployeeService implements IEmployeeService {

    private long counter = 1L;
    private Map<Long, Employee> employeeMap = new LinkedHashMap<Long, Employee>();

    @Override
    public List<Employee> getEmployees(Long departmentId) {
        Collection<Employee> employees = employeeMap.values();
        ArrayList<Employee> departmentEmployees = new ArrayList<Employee>();

        for (Employee employee : employees) {
            if (employee.getDepartmentId().equals(departmentId)) {
                departmentEmployees.add(employee);
            }
        }

        return departmentEmployees;
    }

    @Override
    public Employee getEmployee(Long employeeId) {
        return employeeMap.get(employeeId);
    }

    @Override
    public void addEmployee(Employee employee) {
        employee.setId(counter++);
        employeeMap.put(employee.getId(), employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeMap.put(employee.getId(), employee);
    }

    @Override
    public void removeEmployee(Long employeeId) {
        employeeMap.remove(employeeId);
    }
}
