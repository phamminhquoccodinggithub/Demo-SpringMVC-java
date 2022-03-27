<%-- 
    Document   : index
    Created on : Mar 15, 2022, 12:49:17 AM
    Author     : Quoc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Homepage</title>
        <link href="<c:url value="/css/style.css"></c:url>" rel="stylesheet">
    </head>
    <body>
        <h1>
            <spring:message code="page.title"/>
        </h1>
        <h3>
            <spring:message code="page.welcome"/>
        </h3>
            <img src="<c:url value="/images/iphone.jpg"/>" alt="test"/>
            <h1>Hello ${name}</h1>
        <a>Go to page</a>
        <ul>
            <c:forEach items="${categories}" var="cat">
                <li>
                    ${cat}
                </li>
            </c:forEach>            
        </ul>
        <ul>
            <c:forEach begin="1" end="10" var="id">
                <li>2 * ${id} = ${2*id}</li>
                </c:forEach>
        </ul>
        
    </body>
</html>
