<%@page pageEncoding="UTF-8" isELIgnored="false" contentType="text/html;utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="app"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>update Emp</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css"
          href="${app}/css/style.css"/>
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
                    <a href="#">Main</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                update Emp info:
            </h1>
            <form action="${app}/ems/update" method="post" enctype="multipart/form-data">
                <table cellpadding="0" cellspacing="0" border="0"
                       class="form_table">
                    <tr>
                        <td valign="middle" align="right">
                            id:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" value="${emp.id}" readonly="readonly" name="id">
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            头像:
                        </td>
                        <td valign="middle" align="left">
                            <img width="40px" height="40px" src="${app}/img/${emp.src}"/>
                            <input type="file" name="upload"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            用户名:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="name" value="${emp.name}"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            工资:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="salary" value="${emp.salary}"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            年龄:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="age" value="${emp.age}"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            部门:
                        </td>
                        <td valign="middle" align="left">
                            <select name="departmentId">
                                <c:forEach var="dep" items="${deps}">
                                    <c:if test="${emp.departmentId==dep.id}">
                                        <option value="${dep.id}" selected="selected">${dep.name}</option>
                                    </c:if>
                                    <c:if test="${emp.departmentId!=dep.id}">
                                        <option value="${dep.id}">${dep.name}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </td>
                        <%--<td>
                            <input type="hidden" value="${dname2}" name="dname">
                        </td>--%>

                    </tr>
                </table>
                <p>
                    <input type="submit" class="button" value="修改"/>
                </p>
            </form>
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
