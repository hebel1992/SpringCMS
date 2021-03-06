<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}/category"/>
<html>
<head>
    <title>Category List</title>
</head>
<body>
<h1>Lista kategorii:</h1>
<table border="1">
    <thead style="font-weight: bold">
    <tr>
        <td>
            Nazwa
        </td>
        <td>
            Opis
        </td>
        <td>
            Akcja
        </td>
    </tr>
    </thead>
    <c:forEach items="${categories}" var="category">
        <tr>
            <td>${category.name}</td>
            <td>${category.description}</td>
            <td><a href="${contextPath}/edit/${category.id}">Edytuj</a>/<a
                    href="${contextPath}/delete/${category.id}">Usun</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="${contextPath}/add">
    <button>Dodaj nową</button>
</a>
<a href="/">
    <button>Wróć</button>
</a>
</body>
</html>
