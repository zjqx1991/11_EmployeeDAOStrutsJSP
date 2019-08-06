<%--
  Created by IntelliJ IDEA.
  User: revanwang
  Date: 2019-08-05
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>员工信息列表</title>
</head>
<body>
    <s:form namespace="/" action="employee">
        <s:textfield name="qo.name">名称</s:textfield>
        <s:textfield name="qo.minSalary">价格从</s:textfield>
        <s:textfield name="qo.maxSalary">到</s:textfield>
        <s:submit value="查询"></s:submit>
    </s:form>
    <s:a namespace="/" action="employee_input">添加新员工</s:a>
    <table border="1" cellpadding="0"   cellspacing="0" width="90%">
        <tr>
            <th>员工编号</th>
            <th>员工名称</th>
            <th>员工年龄</th>
            <th>员工工资</th>
            <th scope="2">操作</th>
        </tr>
        <s:iterator value="#pageResult.reslutList">
            <tr>
                <td><s:property value="id"></s:property> </td>
                <td><s:property value="name"></s:property> </td>
                <td><s:property value="age"></s:property> </td>
                <td><s:property value="salary"></s:property> </td>
                <td align="center">
                    <s:url var="inputUrl" namespace="/" action="employee_input">
                        <s:param name="employee.id" value="id"></s:param>
                    </s:url>
                    <a href="<s:property value="#inputUrl" /> ">编辑</a>
                    <s:a namespace="/" action="employee_delete" >
                        <s:param name="employee.id" value="id" />删除
                    </s:a>
                </td>
            </tr>
        </s:iterator>
        <tr align="center">
            <td colspan="5">
                <s:a namespace="/" action="employee">
                    <s:param name="qo.currentPage" value="1"/>
                    首页
                </s:a>
                <s:a namespace="/" action="employee">
                    <s:param name="qo.currentPage" value="#pageResult.prevPage"/>
                    上一页
                </s:a>
                <s:a namespace="/" action="employee">
                    <s:param name="qo.currentPage" value="#pageResult.nextPage"/>
                    下一页
                </s:a>
                <s:a namespace="/" action="employee">
                    <s:param name="qo.currentPage" value="#pageResult.totalPage"/>
                    尾页
                </s:a>
                共<s:property value="#pageResult.totalPage" />页，
                当前<s:property value="#pageResult.currentPage" />/<s:property value="#pageResult.totalPage" />
            </td>
        </tr>
    </table>
</body>
</html>
