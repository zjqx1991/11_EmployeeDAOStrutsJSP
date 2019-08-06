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
    <s:a namespace="/" action="employee_input">添加新员工</s:a>
    <table border="1" cellpadding="0"   cellspacing="0" width="90%">
        <tr>
            <th>员工编号</th>
            <th>员工名称</th>
            <th>员工年龄</th>
            <th>员工工资</th>
            <th scope="2">操作</th>
        </tr>
        <s:iterator value="#employees">
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
    </table>
</body>
</html>
