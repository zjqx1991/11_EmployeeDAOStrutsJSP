package com.revanwang.employee.dao.impl;

import com.revanwang.employee.dao.IEmployeeDAO;
import com.revanwang.employee.domain.Employee;
import com.revanwang.employee.util.db.JdbcTemplate;
import com.revanwang.employee.util.result.IResultHandle;
import com.revanwang.employee.util.result.impl.ResultHandle;

import java.util.List;

/**
 * @program: 01_EmployeeDAOStrutsJSP
 * @description: 员工信息DAO接口实现
 * @author: Revan.Wang
 * @create: 2019-08-05 10:24
 **/
public class EmployDAOImpl implements IEmployeeDAO {
    @Override
    public void save(Employee e) {
        String sql = "INSERT INTO t_employee (name, age, salary) VALUES (?, ?, ?)";
        JdbcTemplate.executeUpdate(sql, e.getName(), e.getAge(), e.getSalary());
    }

    @Override
    public void delete(Employee e) {
        String sql = "DELETE FROM t_employee WHERE id = ?";
        JdbcTemplate.executeUpdate(sql, e.getId());
    }

    @Override
    public void update(Employee e) {
        String sql = "UPDATE t_employee SET name = ?, age = ?, salary = ? WHERE id = ?";
        JdbcTemplate.executeUpdate(sql, e.getName(), e.getAge(), e.getSalary(), e.getId());
    }

    @Override
    public Employee get(Employee e) {
        String sql = "SELECT * FROM t_employee WHERE id = ?";
        List<Employee> eList = JdbcTemplate.executeQuery(sql, new ResultHandle<Employee>(Employee.class), e.getId());
        return eList.size() == 1 ? eList.get(0) : null;
    }

    @Override
    public List<Employee> getList() {
        String sql = "SELECT * FROM t_employee";
        return JdbcTemplate.executeQuery(sql, new ResultHandle<>(Employee.class));
    }
}
