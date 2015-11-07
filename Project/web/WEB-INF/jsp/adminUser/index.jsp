<%-- 
    Document   : index
    Created on : Jun 18, 2015, 10:23:32 PM
    Author     : Kripesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../../header.jsp" %>
<div class="box">
    <div class="row">
<div class="pull-right" style="margin-right:30px">
    <p>
        <br/>
        <a href="${pageContext.request.contextPath}/admin/user/add" class="btn btn-primary btn-xs"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Add</a>
    </p>
</div>
</div>
    <div class="box-header">
        <h3 class="box-title">User Data Table With Full Features</h3>
    </div><!-- /.box-header -->
    <div class="box-body">
        <table id="example1" class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th>User Id</th>
                    <th>User Name</th>
                    <th>Password</th>
                    <th>Email</th>
                    <th>Role Name</th>
                    <th>Action</th>
                </tr>
            </thead>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.getUserId()}</td>
                    <td>${user.getUsername()}</td>
                    <td>${user.getPassword()} </td>
                    <td>${user.getEmail()} </td>
                    <td>${user.getRole().getRoleName()}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/user/edit?id=${user.getUserId()}"class="btn btn-success btn-xs"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>Edit</a>
                        <a href="${pageContext.request.contextPath}/admin/user/delete?id=${user.getUserId()}" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div><!-- /.box-body -->
</div>
        <script>
            $(document).on('ready',function(){
               $('.btn-danger').on('click',function(){
                  if(confirm('Do you want to Delete?')===false){
                       return false;
                  }
               }); 
            });  
        </script>
<%@include file="../../footer.jsp" %>
