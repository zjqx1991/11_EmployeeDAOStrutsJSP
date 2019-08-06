package com.revanwang.employee.query;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import sun.management.counter.Units;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: 01_EmployeeDAOStrutsJSP
 * @description: Employee查询对象
 * @author: Revan.Wang
 * @create: 2019-08-06 15:40
 **/
public class EmployeeQueryObject {
    @Getter@Setter
    private String name;            //员工名称
    @Getter@Setter
    private BigDecimal minSalary;   //员工最低工资
    @Getter@Setter
    private BigDecimal maxSalary;   //员工最高工资

    @Getter@Setter
    private Integer currentPage = 1;
    @Getter@Setter
    private Integer pageSize = 10;
    private List<String> conditions = new ArrayList<>();
    private List<Object> paramsList = new ArrayList();

    public String getQuery() {
        if (this.name != null) {
            this.paramsList.add("%" + this.name + "%");
            this.conditions.add("name LIKE ?");
        }
        if (this.minSalary != null) {
            this.paramsList.add(this.minSalary);
            this.conditions.add("salary >= ?");
        }
        if (this.maxSalary != null) {
            this.paramsList.add(this.maxSalary);
            this.conditions.add("salary <= ?");
        }
        if (this.conditions.size() == 0) return "";
        return " WHERE " + StringUtils.join(this.conditions, " AND ");
    }

    public List getParams() {

        return this.paramsList;
    }
}
