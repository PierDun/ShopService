<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    <%@ include file="/css/filter_style.css" %>
</style>
<body>
</form>
<ul class="nav nav-tabs filter-tabs" data-tabs="tabs" id="filter-tab">
    <li class="nav-item active">
        <a class="nav-link active" data-toggle="tab" href="#filter">Find By Type</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" data-toggle="tab" href="#add">Add Wheels</a>
    </li>
</ul>
<div class="tab-content">
    <div class="tab-pane fade show active" id="filter">
        <form class="filter-form" name="filterForm">
            <select id = "type"> Vehicle Type:
                <option value="PLANE">PLANE</option>
                <option value="BOAT">BOAT</option>
                <option value="SHIP">SHIP</option>
                <option value="MOTORCYCLE">MOTORCYCLE</option>
                <option value="CHOPPER">CHOPPER</option>
            </select>

            <div class="mx-auto" style="color: red">
                <h7  id = "error1"></h7>
            </div>

            <input type="button" class="btn btn-primary mx-auto mt-3" value="find" onclick="filter()"/>
        </form>
    </div>
    <div class="tab-pane fade" id="add">
        <form class="filter-form" name="sortForm">
            <p>ID:</p>
            <div class="filter-form__range">
                <input type="text" id="id" class="form-control Age"/>
            </div>

            <p>Wheels to Add:</p>
            <div class="filter-form__range">
                <input type="text" id="wheels" class="form-control Age"/>
            </div>

            <div class="mx-auto" style="color: red">
                <h7  id = "error2"></h7>
            </div>

            <input type="button" class="btn btn-primary mx-auto mt-3" value="add" onclick="add()"/>
        </form>
    </div>
</div>
<script>
    <%@ include file="/js/filter.js" %>
</script>
</body>
</html>