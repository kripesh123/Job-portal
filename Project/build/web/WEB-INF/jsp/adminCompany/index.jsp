<%-- 
    Document   : index
    Created on : Jun 20, 2015, 7:15:12 PM
    Author     : Kripesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../../header.jsp" %>
<div class="box">
    <div class="row">
        <div class="pull-right" style="margin-right:30px">
            <p>
                <br/>
                <a href="${pageContext.request.contextPath}/admin/company/add" class="btn btn-primary btn-xs"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Add</a>
            </p>
        </div>
    </div>
    <div class="box-header">
        <h3 class="box-title">Company Data Table With Full Features</h3>
    </div><!-- /.box-header -->
    <div class="box-body">
        <table id="example1" class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th>Company Id</th>
                    <th>Company Name</th>
                    <th>Company Description</th>
                    <th>Company Logo</th>
                    <th>Action</th>
                </tr>
            </thead>
            <c:forEach var="com" items="${company}">
                <tr>
                    <td>${com.getCompanyId()}</td>
                    <td>${com.getCompanyName()}</td>
                    <td>${com.getCompanyDescription()}</td>
                    <td>${com.getCompanyLogo()}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/company/edit?id=${com.getCompanyId()}"class="btn btn-success btn-xs"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>Edit</a>
                        <br/>
                        <br/>
                        <a href="${pageContext.request.contextPath}/admin/company/delete?id=${com.getCompanyId()}" id="btnDelete" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div><!-- /.box-body -->
</div>
<script>
    $(document).on('ready', function () {
        $('.btn-danger').on('click', function () {
            if (confirm('Do you want to Delete?') === false) {
                return false;
            }
        });
    });
</script>
<%@include file="../../footer.jsp" %>
