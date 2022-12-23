<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>СОА - 2-ая Лабораторная</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<style>
    <%@ include file="/css/main.css" %>
</style>
<body>
<div class="main-page">
    <div class="table" align="center">
        <caption><h2>List of Vehicles</h2></caption>
        <table border="1" cellpadding="13" class="table">
            <thead class="thead-dark">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>X</th>
                <th>Y</th>
                <th>Creation Date</th>
                <th>Engine Power</th>
                <th>Number of Wheels</th>
                <th>Type</th>
                <th>Fuel Type</th>
            </tr>
            </thead>
        </table>
    </div>
    <div class="filter">
        <jsp:include page="filter.jsp"/>
    </div>
</div>
</body>
</html>