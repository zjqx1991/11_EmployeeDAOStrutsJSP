package com.revanwang.employee.dao.impl;

import com.revanwang.employee.dao.IEmployeeDAO;
import com.revanwang.employee.domain.Employee;
import com.revanwang.employee.query.EmployeeQueryObject;
import com.revanwang.employee.query.PageResult;
import com.revanwang.employee.util.db.JdbcTemplate;
import com.revanwang.employee.util.result.IResultHandle;
import com.revanwang.employee.util.result.impl.ResultHandle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @program: 01_EmployeeDAOStrutsJSP
 * @description: 员工信息DAO接口实现
 * @author: Revan.Wang
 * @create: 2019-08-05 10:24
 **/
public class EmployDAOImpl implements IEmployeeDAO {
    @Override
    public List<Employee> query(EmployeeQueryObject qo) {
        String sql = "SELECT * FROM t_employee" + qo.getQuery();
        System.out.println(sql);
        System.out.println(qo.getParams());

        return JdbcTemplate.executeQuery(sql, new ResultHandle<>(Employee.class), qo.getParams().toArray());
    }

    @Override
    public PageResult pageQuery(EmployeeQueryObject qo) {
        String querySql = qo.getQuery();

        //1、查询结果总个数
        String countSql = "SELECT COUNT(*) FROM t_employee" + querySql;
        int count = JdbcTemplate.executeQuery(countSql, new IResultHandle<Integer>() {
            @Override
            public Integer handler(ResultSet rs) throws SQLException {
                if (rs.next()) {
                    return rs.getInt(1);
                }
                return 0;
            }
        }, qo.getParams().toArray());

        //2、查询结果集
        String resultSql = "SELECT * FROM t_employee" + querySql + " LIMIT ?, ?";
        qo.getParams().add((qo.getCurrentPage() - 1) * qo.getPageSize());
        qo.getParams().add(qo.getPageSize());
        List result = JdbcTemplate.executeQuery(resultSql, new ResultHandle<Employee>(Employee.class), qo.getParams().toArray());
        return new PageResult(result, count, qo.getCurrentPage(), qo.getPageSize());
    }

    /******************* 以上是高级查询 ******************/
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
