<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}/draft"/>
<html>
<head>
    <title>Delete Draft</title>
</head>
<body>
<h1>Jestes pewny?</h1>
<a href="${contextPath}/deleteExecute/${draft.id}/true">
    <button>Tak</button>
</a>
<a href="${contextPath}/deleteExecute/${draft.id}/false">
    <button>Nie</button>
</a>
</body>
</html>
