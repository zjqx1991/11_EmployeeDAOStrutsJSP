<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: revanwang
  Date: 2019-08-06
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit interface</title>
</head>
<body>
    <s:form namespace="/" action="employee_savaOrUpdate" method="POST" theme="simple">
        <table border="1" cellspacing="0" cellpadding="0">
            <s:hidden name="employee.id"></s:hidden>
            <tr>
                <td>员工名称</td>
                <td><s:textfield name="employee.name"></s:textfield> </td>
            </tr>
            <tr>
                <td>员工年龄</td>
                <td><s:textfield name="employee.age" /> </td>
            </tr>
            <tr>
                <td>员工工资</td>
                <td><s:textfield name="employee.salary" /> </td>
            </tr>
            <tr>
                <td scope="2">
                    <input type="submit" value="保存">
                </td>
            </tr>
        </table>
    </s:form>
</body>
</html>
