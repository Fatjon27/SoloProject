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
    <title>Tacos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body class="bg-light">
    <div class="container bordering">
        <h1 class="align-items-center text-center">Here are the Report Details</h1>
        <p class="align-items-center text-center">Date of the Report : ${report.date}</p>
        <p class="align-items-center text-center">Product of the Report : ${report.repair.deviceSerial}</p>
        <p class="align-items-center text-center">Price of the Repair : ${report.price} $</p>
        <p class="align-items-center text-center">Is Report refused? : ${report.refused}</p>
        <p class="align-items-center text-center">Is Report completed? : ${report.completed}</p>
        <p class="align-items-center text-center">Is Report paid? : ${report.paid}</p>
        <div class="align-items-center justify-content-center text-center">
            <c:if test="${user.equals(report.getTechnician())}" >
                <form method="get" action="/report/${report.id}/${report.repair.id}">
                    <input type="submit" value="Edit the Report" class="btn btn-outline-primary text-center align-items-center ">
                </form>
            </c:if>
        </div>
        <div class="align-items-center justify-content-center text-center">
            <c:if test="${user.id==1}">
                <form method="get" action="/acceptance/dashboard" >
                    <input type="submit" value="Go Back" class="btn-outline-primary btn">
                </form>
            </c:if>
            <c:if test="${user.id==2}">
                <form method="get" action="/technician/dashboard" >
                    <input type="submit" value="Go Back" class="btn-outline-primary btn">
                </form>
            </c:if>
            <c:if test="${user.id!=1 && user.id!=2}">
                <form method="get" action="/dashboard" >
                    <input type="submit" value="Go Back" class="btn-outline-primary btn">
                </form>
            </c:if>

        </div>
    </div>
</body>
</html>