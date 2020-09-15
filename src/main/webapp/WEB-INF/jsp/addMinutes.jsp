
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page pageEncoding="UTF-8" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Add Minutes Exercised</h1>

Language : <a href="?language=en">England</a> | <a href="?language=bg">Bulgarian</a>

<form:form modelAttribute="exercise">
    <table>
        <tr>
            <td><spring:message code="minutes.text"/></td>
            <td><form:input path="minutes"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Enter Exercise">
            </td>
        </tr>
    </table>
</form:form>

<h1>Goal for the day: ${sessionScope.goal.minutes}</h1>
</body>
</html>
