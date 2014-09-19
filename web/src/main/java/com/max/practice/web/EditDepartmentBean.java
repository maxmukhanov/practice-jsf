package com.max.practice.web;

import com.max.practice.model.Department;
import com.max.practice.service.IDepartmentService;
import org.apache.log4j.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 * Created by mmukhanov on 09.09.2014.
 */
@ManagedBean
@RequestScoped
public class EditDepartmentBean {
    private static final Logger LOGGER = Logger.getLogger(EditDepartmentBean.class);

    @ManagedProperty(value = "#{departmentService}")
    private IDepartmentService departmentService;

    private Department department;

    public void setDepartmentService(IDepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public Department getDepartment() {
        if (department == null) {
            String departmentId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("departmentId");

            if (departmentId != null) {
                LOGGER.debug("Getting department by id " + departmentId);
                department = departmentService.getDepartment(Long.valueOf(departmentId));
            } else {
                department = new Department();
            }
        }

        return department;
    }

    public String save() {
        if (department.getId() > 0L) {
            departmentService.updateDepartment(department);
        } else {
            departmentService.addDepartment(department);
        }

        return "success";

    }
}
