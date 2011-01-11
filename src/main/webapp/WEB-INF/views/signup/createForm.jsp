<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
</head>
<body>
<form:form modelAttribute="user" method="post">
    <fieldset>
        <p>
            <form:label for="username" path="username">username</form:label><br/>
            <form:input path="username"/><form:errors path="username"/>
        </p>
        <p>
            <form:label for="password" path="password">password</form:label><br/>
            <form:input path="password"/><form:errors path="password"/>
        </p>
        <p>
            <form:label for="accessLevel" path="accessLevel">access_level</form:label><br/>
            <form:input path="accessLevel"/><form:errors path="accessLevel"/>
        </p>
        <p>
            <form:label for="email" path="email">email</form:label><br/>
            <form:input path="email"/><form:errors path="email"/>
        </p>
    </fieldset>
</form:form>
</body>
</html>