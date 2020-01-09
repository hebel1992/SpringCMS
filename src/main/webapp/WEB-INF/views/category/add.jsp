<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}/category"/>
<html>
<style>
    .error {
        color: red;
    }
</style>
<head>
    <title>Add Category</title>
</head>
<body>
<h1>Dodaj nową kategorię</h1>
<%--@elvariable id="category" type="pl.coderslab.models.Category"--%>
<form:form action="${contextPath}/add" method="post" modelAttribute="category">

    <div>Tytuł: <form:input path="name" type="text"/>
        <form:errors path="name" cssClass="error"/>
    </div>

    <div>Opis: <form:textarea path="description"/></div>

    <input type="submit" value="Dodaj">
</form:form><br/>
<a href="${contextPath}/list">
    <button>Wróć</button>
</a>
</body>
</html>
