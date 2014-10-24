package com.max.practice.web;

import com.max.practice.model.Department;
import com.max.practice.service.IDepartmentService;
import org.ajax4jsf.model.DataVisitor;
import org.ajax4jsf.model.ExtendedDataModel;
import org.ajax4jsf.model.Range;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@ManagedBean
@ViewScoped
public class DepartmentListBean extends ExtendedDataModel<Department>  implements Serializable {
    private static final Logger LOGGER = Logger.getLogger(DepartmentListBean.class);

    private static final Integer DEFAULT_PAGE = 1;
    private static final Integer DEFAULT_PAGE_SIZE = 2;

    @ManagedProperty(value = "#{departmentService}")
    private IDepartmentService departmentService;

    private Integer page = DEFAULT_PAGE;
    private Integer pageSize = DEFAULT_PAGE_SIZE;

    private Integer rowCount;

    private Map<Object, Department> data = new HashMap<Object, Department>();
    private Object rowKey;

    @PostConstruct
    public void init() {
        LOGGER.debug("init method was called");
        rowCount = departmentService.getDepartmentsCount();
    }

    public void setDepartmentService(IDepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }


    @Override
    public void setRowKey(Object rowKey) {
        this.rowKey = rowKey;
    }

    @Override
    public Object getRowKey() {
        return rowKey;
    }

    @Override
    public void walk(FacesContext facesContext, DataVisitor dataVisitor, Range range, Object argument) {
        LOGGER.debug("Getting departments for page: " + page + ", pageSize: " + pageSize);

        List<Department> departments = departmentService.getDepartments(page, pageSize, null, null);

        for (Department department : departments) {
            data.put(department.getId(), department);

            dataVisitor.process(facesContext, department.getId(), argument);
        }
    }

    @Override
    public int getRowCount() {
        return rowCount;
    }

    @Override
    public Department getRowData() {
        return data.get(rowKey);
    }

    @Override
    public int getRowIndex() {
        return 0;
    }

    @Override
    public Object getWrappedData() {
        return null;
    }

    @Override
    public boolean isRowAvailable() {
        return data.containsKey(rowKey);
    }

    @Override
    public void setRowIndex(int i) {
    }

    @Override
    public void setWrappedData(Object o) {
        LOGGER.debug("setWrappedData");
    }

    public void remove() {
        String departmentId = FacesContext.getCurrentInstance().getExternalContext().
                getRequestParameterMap().get("departmentId");
        LOGGER.debug("Removing department " + departmentId);
        departmentService.removeDepartment(Long.valueOf(departmentId));

        rowCount = departmentService.getDepartmentsCount();
    }
}
