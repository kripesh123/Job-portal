

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<table class="table table-bordered table-striped">
    <tr>
        <th>Edit Date</th>
        <th>Schedule Status</th>
        <th>Remarks</th>
    </tr>
    <tr>
        <td>${sch.getEditDate()}</td>
        <td>${sch.getScheduleStatus()}</td>
        <td>${sch.getRemarks()}</td>
    </tr>
</table>








