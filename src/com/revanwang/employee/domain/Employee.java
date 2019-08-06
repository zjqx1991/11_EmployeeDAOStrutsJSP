package com.revanwang.employee.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @program: 01_EmployeeDAOStrutsJSP
 * @description: 员工信息
 * @author: Revan.Wang
 * @create: 2019-08-05 10:05
 **/
@Data
public class Employee {
    private Long     id;
    private String name;
    private Integer age;
    private BigDecimal salary;
}
