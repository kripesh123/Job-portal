
<%@include file="../../header.jsp" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="box box-primary">
    <div class="box-header">
        <h3 class="box-title">Edit Role</h3>
    </div>
    <spring:form action="${pageContext.request.contextPath}/admin/role/update?id=${role.getRoleId()}" method="post" commandName="Role">
        <div class="box-body">
            <div class="form-group">
                <label for="roleName">Role Name</label>
                <spring:input path="roleName" type="text" class="form-control" value = "${role.getRoleName()}"/>
            </div>  
            </div>
            <div class="box-footer">
                <button type="submit" class="btn btn-primary">Save</button>
                <a href="${pageContext.request.contextPath}/admin/role"class="btn btn-danger">Cancel</a>
            </div>
        </spring:form>
    </div>
    <%@include file="../../footer.jsp" %>

