<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create New Report</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body class="bg-light container">
    <div class="container">
        <%--@elvariable id="report" type="java"--%>
        <form:form action="/acceptance/newReport/${repair.id}" method="post" modelAttribute="report">
            <p>
                <form:label path="date" class="form-label">Date</form:label>
                <form:errors path="date" class="text-danger"/>
                <form:input path="date" type="date" class="form-control"/>
            </p>
            <input type="submit" value="Submit" class="btn btn-outline-primary">
        </form:form>
    </div>
    <div class="container">
        <form method="get" action="/acceptance/dashboard">
            <input type="submit" class="btn-outline-primary btn" value="Cancel">
        </form>
    </div>
</body>
</html>