package com.revanwang.employee.dao;

import com.revanwang.employee.dao.impl.EmployDAOImpl;
import com.revanwang.employee.domain.Employee;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class IEmployeeDAOTest {

    private IEmployeeDAO employeeDAO = new EmployDAOImpl();

    @Test
    public void save() {
        Employee employee = new Employee();
        employee.setName("Revan_4");
        employee.setAge(34);
        employee.setSalary(new BigDecimal(2400));

        employeeDAO.save(employee);
    }

    @Test
    public void delete() {
        Employee e = new Employee();
        e.setId(1L);
        employeeDAO.delete(e);
    }

    @Test
    public void update() {
        Employee e = new Employee();
        e.setId(5L);
        e.setName("Revan_5");
        e.setAge(35);
        e.setSalary(new BigDecimal(2500));

        employeeDAO.update(e);
    }

    @Test
    public void get() {
        Employee e = new Employee();
        e.setId(5L);
        System.out.println("获取id = 5数据：=" + employeeDAO.get(e));
    }

    @Test
    public void getList() {
        List<Employee> list = employeeDAO.getList();
        Iterator<Employee> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}