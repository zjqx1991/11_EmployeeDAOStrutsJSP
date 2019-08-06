package com.revanwang.employee.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.revanwang.employee.dao.IEmployeeDAO;
import com.revanwang.employee.dao.impl.EmployDAOImpl;
import com.revanwang.employee.domain.Employee;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

/**
 * @program: 01_EmployeeDAOStrutsJSP
 * @description:
 * @author: Revan.Wang
 * @create: 2019-08-05 15:38
 **/
public class EmployeeAction extends ActionSupport {

    @Getter
    private Employee employee = new Employee(); //Action与JSP 数据相互传值通道
    private IEmployeeDAO employeeDAO = new EmployDAOImpl();
    private final String LIST = "list";

    @Override
    public String execute() {
        List<Employee> eList = employeeDAO.getList();
        //存储数据到 list.jsp 的 Context中
        ActionContext.getContext().put("employees", eList);
        return LIST;
    }

    @Override
    public String input() throws Exception {
        if (this.employee.getId() != null) {
            this.employee = employeeDAO.get(this.employee);
        }
        return INPUT;
    }

    public String savaOrUpdate() {
        if (this.employee.getId() == null) {
            //新加
            employeeDAO.save(this.employee);
        }
        else {
            //编辑
            employeeDAO.update(this.employee);
        }
        return SUCCESS;
    }

    public String delete() {
        if (this.employee.getId() != null) {
            this.employeeDAO.delete(this.employee);
        }
        return SUCCESS;
    }
}
