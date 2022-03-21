<%-- 
    Document   : login
    Created on : Mar 21, 2022, 12:43:05 PM
    Author     : Quoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOGIN PAGE</title>
    </head>
    <body>
        <h1>LOGIN</h1>
        <c:if test="${msg.equals('SUCCESSFULLY')==true}">
            <h1 style="color: green">${msg}</h1>
        </c:if>
        <c:if test="${msg.equals('FAILED')==true}">
            <h1 style="color: red">${msg}</h1>
        </c:if>        
        <form:form method="post" action="/A3SpringMVCDemo/login" modelAttribute="user">
            Username: <form:input path="username"/>
            Password: <form:password path="password"/>
            <input type="submit" value="Login"/>
        </form:form>
    </body>
</html>
