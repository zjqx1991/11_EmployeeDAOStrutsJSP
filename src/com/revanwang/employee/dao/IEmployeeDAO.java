package com.revanwang.employee.dao;

import com.revanwang.employee.domain.Employee;
import com.revanwang.employee.query.EmployeeQueryObject;

import java.util.List;

/**
 *  员工信息DAO接口
 */
public interface IEmployeeDAO {

    /**
     * 保存员工信息
     * @param e 新增员工
     */
    void save(Employee e);

    /**
     * 删除员工
     * @param e 被删除员工
     */
    void delete(Employee e);

    /**
     * 编辑员工信息
     * @param e 编辑员工信息
     */
    void update(Employee e);

    /**
     * @param e 获取员工信息
     * @return  查询的员工
     */
    Employee get(Employee e);

    /**
     * @return 所有员工信息
     */
    List<Employee> getList();

    /**
     * @param qo 查询条件对象
     * @return 所有员工信息
     */
    List<Employee> query(EmployeeQueryObject qo);

}
