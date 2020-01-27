<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}/draft"/>
<html>
<style>
    .error {
        color: red;
    }
</style>
<head>
    <title>Edit Draft</title>
</head>
<body>
<h1>Edycja szkicu artykułu</h1>
<%--@elvariable id="draft" type="pl.coderslab.models.Article"--%>
<form:form action="${contextPath}/edit" method="post" modelAttribute="draft">
    <form:hidden path="id"/>
    <form:hidden path="created"/>
    <div>Tytul: <form:input path="title" type="text"/>
        <form:errors path="title" cssClass="error"/>
    </div><br/>
    Treść:
    <div><form:textarea path="content" cols="100" rows="15"/>
        <form:errors path="content" cssClass="error"/>
    </div><br/>
    <div> Autor: <form:select path="author">
        <form:option value="" label="--Please select--"/>
        <form:options items="${authors}" itemValue="id" itemLabel="lastName"/>
    </form:select>
    </div><br/>
    <div> Kategoria: <form:select path="categories" items="${categories}" itemLabel="name" itemValue="id"
                                  multiple="true"/>
        <form:errors path="categories" cssClass="error"/>
    </div><br/>
    <input type="submit" value="Zaktualizuj">
</form:form>
<a href="${contextPath}/list">
    <button>Wróć</button>
</a>
</body>
</html>
