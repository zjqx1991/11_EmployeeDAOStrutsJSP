package com.revanwang.employee.dao;

import com.revanwang.employee.dao.impl.EmployDAOImpl;
import com.revanwang.employee.domain.Employee;
import com.revanwang.employee.query.EmployeeQueryObject;
import com.revanwang.employee.query.PageResult;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.*;

public class IEmployeeDAOTest {

    private IEmployeeDAO employeeDAO = new EmployDAOImpl();

    @Test
    public void save() {

        for (int i = 20; i < 50; i++) {

            Employee employee = new Employee();
            employee.setName("test_" + i);
            employee.setAge(i);
            employee.setSalary(new BigDecimal(800 + ThreadLocalRandom.current().nextInt(0, 1200)));

            employeeDAO.save(employee);
        }

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

    @Test
    public void query() {
        EmployeeQueryObject qo = new EmployeeQueryObject();
        qo.setName("Revan");
        qo.setMinSalary(new BigDecimal(2500));
        qo.setMaxSalary(new BigDecimal(7999));
        List<Employee> list = employeeDAO.query(qo);
        Iterator<Employee> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
    @Test
    public void pageQuery() {
        EmployeeQueryObject qo = new EmployeeQueryObject();
        qo.setName("Revan");
        qo.setMinSalary(new BigDecimal(2500));
        qo.setMaxSalary(new BigDecimal(7999));
        PageResult pageResult = employeeDAO.pageQuery(qo);
        List result = pageResult.getReslutList();
        System.out.println(result.size());
//        List<Employee> list = employeeDAO.query(qo);
//        Iterator<Employee> it = list.iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }
    }
}