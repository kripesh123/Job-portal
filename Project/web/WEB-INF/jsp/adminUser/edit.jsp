
<%@include file="../../header.jsp" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="box box-primary">
    <div class="box-header">
        <h3 class="box-title">Edit User</h3>
    </div>
    <spring:form action="${pageContext.request.contextPath}/admin/user/update?id=${user.getUserId()}" method="post" commandName="User">
        <div class="box-body">
            <div class="form-group">
                <label for="roleId">Role</label>
                
                <spring:select path="roleId" class="form-control">
                    <spring:option value="0">${role.getRoleName()}</spring:option>
                    <c:forEach var="role" items="${roles}">
                        <spring:option value="${role.getRoleId()}">${role.getRoleName()}
                    </spring:option>
                    </c:forEach>
                </spring:select>
            </div>  
            <div class="form-group">
                <label for="username">Username</label>
                <spring:input path="username" type="text" class="form-control" value = "${user.getUsername()}" disabled="true"/>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <spring:input path="password" type="text" value = "${user.getPassword()}" class="form-control" disabled="true"/>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <spring:input path="email" type="email" value = "${user.getEmail()}" class="form-control"/>
            </div>
            </div>
            <div class="box-footer">
                <button type="submit" class="btn btn-primary">Save</button>
                <a href="${pageContext.request.contextPath}/admin/user"class="btn btn-danger">Cancel</a>
            </div>
        </spring:form>
    </div>
    <%@include file="../../footer.jsp" %>

