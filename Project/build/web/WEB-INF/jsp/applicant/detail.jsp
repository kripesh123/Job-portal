

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<table class="table table-bordered table-striped">
    <tr>
        <th>Email</th>
        <th>Contact No</th>
        <th>Cover Letter</th>
        <th>Resume</th>
    </tr>
        <tr>
            <td>${app.getEmail()}</td>
            <td>${app.getContactNo()}</td>
            <td><a href="${app.getCoverLetter()}">Cover Letter</a></td>
            <td><a href="${app.getResume()}">Resume</a></td>
        </tr>
</table>








