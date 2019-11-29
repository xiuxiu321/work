<%@page pageEncoding="UTF-8" isELIgnored="false" contentType="text/html;utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="app"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>emplist</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${app}/css/style.css"/>
</head>
<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <p>
                    2009/11/20
                    <br/>
                </p>
            </div>
            <div id="topheader">
                <h1 id="title">
                    <a href="#">main</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                Welcome!
            </h1>
            <table class="table">
                <tr class="table_header">
                    <td>
                        ID
                    </td>
                    <td>
                        头像
                    </td>
                    <td>
                        姓名
                    </td>
                    <td>
                        工资
                    </td>
                    <td>
                        年龄
                    </td>
                    <td>
                        部门名称
                    </td>
                    <td>
                        操作
                    </td>
                </tr>
                <c:forEach items="${emps}" var="emp">
                    <tr class="row1">
                        <td>
                                ${emp.id}
                        </td>
                        <td>
                            <img width="40px" height="40px" src="${app}/img/${emp.src}"/>
                        </td>

                        <td>
                                ${emp.name}
                        </td>
                        <td>
                                ${emp.salary}
                        </td>
                        <td>
                                ${emp.age}
                        </td>
                        <td>
                                ${emp.department.name}
                        </td>
                        <td>
                            <a href="${app}/ems/delete?id=${emp.id}&departmentId=${emp.departmentId}">delete emp</a>&nbsp;<a
                                href="${app}/ems/before?id=${emp.id}">update emp</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">
            ABC@126.com
        </div>
    </div>
</div>
</body>
</html>
