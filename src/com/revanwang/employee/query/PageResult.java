package com.revanwang.employee.query;

import lombok.Getter;

import java.util.List;

/**
 * @program: 01_EmployeeDAOStrutsJSP
 * @description: 分页查询结果
 * @author: Revan.Wang
 * @create: 2019-08-06 16:34
 **/
@Getter
public class PageResult {
    private List reslutList;        //查询出的结果集（查询SQL）
    private Integer totalCount;     //总数据条数（查询SQL）

    private Integer currentPage = 1;//当前页
    private Integer pageSize = 3;   //每页个数

    private Integer prevPage;       //上一页
    private Integer nextPage;       //下一页
    private Integer totalPage;      //总页数

    public PageResult(List reslutList, Integer totalCount, Integer currentPage, Integer pageSize) {
        this.reslutList = reslutList;
        this.totalCount = totalCount;
        this.currentPage = currentPage;
        this.pageSize = pageSize;

        //-------------
        this.totalPage = this.totalCount % this.pageSize == 0 ? this.totalCount / this.pageSize : this.totalCount / this.pageSize + 1;
        this.prevPage = this.currentPage - 1 >= 1 ? this.currentPage - 1 : 1;
        this.nextPage = this.currentPage + 1 <= this.totalPage ? this.currentPage + 1 : this.totalPage;
    }
}
