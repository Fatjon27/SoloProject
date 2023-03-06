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
    <title>Technician Dashboard</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body class="bg-light">
<nav class="navbar navbar-expand-xl navbar-dark bg-dark container">
    <div class="container-fluid">
        <div class="collapse navbar-collapse show" id="navbarDark">
            <ul class="navbar-nav me-auto mb-2 mb-xl-0">
                <li class="nav-item">
                    <h2 class="nav-link active text-center align-items-center" aria-current="page">Hello ${user.name}!</h2>
                </li>
            </ul>
            <form class="d-flex" action="/logout" method="get">
                <button class="btn btn-outline-light" type="submit">Logout</button>
            </form>
        </div>
    </div>
</nav>
<div class="container">
    <h2 class="text-center align-items-center">All Reports</h2>
    <table class="table table-bordered table-hover">
        <thead class="table-dark">
        <tr>
            <th>Name of the Product</th>
            <th>Date</th>
            <th>Price</th>
            <th>Refused?</th>
            <th>Completed?</th>
            <th>Details</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${reports}" var="report">
            <tr>
                <td>${report.repair.deviceSerial}</td>
                <td>${report.getDate()}</td>
                <td>${report.getPrice()}</td>
                <td>${report.getRefused()}</td>
                <td>${report.getCompleted()} </td>
                <td><a href="/report/details/${report.id}">Details</a> </td>
            </tr>  </c:forEach>
        </tbody>
    </table>
</div>

    
</body>
</html>