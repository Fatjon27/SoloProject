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
    <title>Edit Report</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body class="container bg-light">
    <div class="container">
        <%--@elvariable id="report" type="java"--%>
        <form:form action="/report/${report.id}/${report.repair.id}" method="put" modelAttribute="report">
            <p>
                <form:label path="date" class="form-label">Date</form:label>
                <form:errors path="date" class="text-danger"/>
                <form:input path="date" type="date" class="form-control"/>
            </p>
            <p>
                <form:label path="price" class="form-label" >Price</form:label>
                <form:errors path="price" class="text-danger"/>
                <form:input path="price" class="form-control " />
            </p>
            <p>
                <form:label path="completed" class="form-label">Completed</form:label>
                <form:errors path="completed" class="text-danger"/>
                <form:checkbox path="completed" class="form-control form-check-input"/>
            </p>
            <p>
                <form:label path="refused" class="form-label" >Refused</form:label>
                <form:errors path="refused" class="text-danger"/>
                <form:checkbox path="refused" class="form-control form-check-input"/>
            </p>
            <p>
                <form:label path="paid" class="form-label" >Paid</form:label>
                <form:errors path="paid" class="text-danger"/>
                <form:checkbox path="paid" class="form-control form-check-input"/>
            </p>
            <p>
                <form:label path="collected" class="form-label">Collected</form:label>
                <form:errors path="collected" class="text-danger"/>
                <form:checkbox path="collected" class="form-control form-check-input"/>
            </p>
            <input type="submit" value="Submit" class="btn-outline-primary btn">
        </form:form>
    </div>
    <div class="container">
        <form method="get" action="/report/details/${report.id}">
            <input type="submit" value="Cancel" class="btn btn-outline-primary">
        </form>
    </div>
</body>
</html>