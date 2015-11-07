<%-- 
    Document   : index
    Created on : Jun 18, 2015, 10:23:13 PM
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
        <a href="${pageContext.request.contextPath}/admin/role/add" class="btn btn-primary btn-xs"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Add</a>
    </p>
</div>
</div>
    <div class="box-header">
        <h3 class="box-title">Role Data Table With Full Features</h3>
    </div><!-- /.box-header -->
    <div class="box-body">
        <table id="example1" class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th>Role Id</th>
                    <th>Role Name</th>
                    <th>Action</th>
                </tr>
            </thead>
            <c:forEach var="role" items="${roles}">
                <tr>
                    <td>${role.getRoleId()}</td>
                    <td>${role.getRoleName()}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/role/edit?id=${role.getRoleId()}"class="btn btn-success btn-xs"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>Edit</a>
                        <a href="${pageContext.request.contextPath}/admin/role/delete?id=${role.getRoleId()}" id="btnDelete" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>Delete</a>
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
