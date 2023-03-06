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
    <title>Create a Repair</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body class="bg-light container">
    <div class="container">
        <h1>Create a Repair</h1>
        <%--@elvariable id="repair" type=""--%>
        <form:form action="/user/repair" method="post" modelAttribute="repair">
            <p>
                <form:label path="deviceSerial" class="form-label">deviceSerial:</form:label>
                <form:errors path="deviceSerial" class="text-danger"/>
                <form:input path="deviceSerial" class="form-control"/>
            </p>
            <p>
                <form:label path="brand" class="form-label" >Brand:</form:label>
                <form:errors path="brand" class="text-danger"/>
                <form:input path="brand" class="form-control"/>
            </p>
            <p>
                <form:label path="deviceTemplate">deviceTemplate:</form:label>
                <form:errors path="deviceTemplate" class="text-danger"/>
                <form:input path="deviceTemplate" class="form-control" />
            </p>
            <p>
                <form:label path="problemDescription" class="form-label" >problemDescription:</form:label>
                <form:errors path="problemDescription" class="text-danger"/>
                <form:input path="problemDescription" class="form-control" />
            </p>
            <p>
                <form:label path="purchaseDate" class="form-label" >purchaseDate:</form:label>
                <form:errors path="purchaseDate" class="text-danger"/>
                <form:input path="purchaseDate" type="date" class="form-control" />
            </p>
            <p>
                <form:label path="warrantyExpiryDate" class="form-label" >warrantyExpiryDate:</form:label>
                <form:errors path="warrantyExpiryDate" class="text-danger"/>
                <form:input path="warrantyExpiryDate" type="date" class="form-control" />
            </p>
            <p>
                <form:label path="additionalNotes" class="form-label" >additionalNotes:</form:label>
                <form:errors path="additionalNotes" class="text-danger"/>
                <form:input path="additionalNotes" class="form-control" />
            </p>
            <p>
                <form:label path="password" class="form-label" >password:</form:label>
                <form:errors path="password" class="text-danger"/>
                <form:input path="password" class="form-control" />
            </p>
            <p>
                <form:label path="fullAddress" class="form-label" >fullAddress:</form:label>
                <form:errors path="fullAddress" class="text-danger"/>
                <form:input path="fullAddress" class="form-control" />
            </p>
            <p>
                <form:label path="telephoneNumber" class="form-label" >telephoneNumber:</form:label>
                <form:errors path="telephoneNumber" class="text-danger"/>
                <form:input path="telephoneNumber" class="form-control" />
            </p>
            <p>
                <form:label path="email" class="form-label" >email:</form:label>
                <form:errors path="email" class="text-danger"/>
                <form:input path="email" class="form-control" />
            </p>
            <p>
                <form:label path="fiscalCode" class="form-label" >fiscalCode:</form:label>
                <form:errors path="fiscalCode" class="text-danger"/>
                <form:input path="fiscalCode" class="form-control" />
            </p>
            <p>
                <form:label path="vatNumber" class="form-label" >vatNumber:</form:label>
                <form:errors path="vatNumber" class="text-danger"/>
                <form:input path="vatNumber" class="form-control" />
            </p>

            <p>
                <form:label path="pec" class="form-label" >pec:</form:label>
                <form:errors path="pec" class="text-danger"/>
                <form:input path="pec" class="form-control" />
            </p>
            <p>
                <form:label path="sdiCode" class="form-label" >sdiCode:</form:label>
                <form:errors path="sdiCode" class="text-danger"/>
                <form:input path="sdiCode" class="form-control" />
            </p>
            <input type="submit" value="Submit" class="btn btn-outline-primary">
        </form:form>
    </div>
    <div class="container">
        <form method="get" action="/dashboard">
            <input type="submit" class="btn-outline-primary btn" value="Cancel">
        </form>
    </div>
</body>
</html>