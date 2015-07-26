<%@include file="../../header.jsp" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="box box-primary">
    <div class="box-header">
        <h3 class="box-title">ADD User</h3>
    </div>
    <spring:form action="${pageContext.request.contextPath}/admin/user/save" method="post" commandName="User">
        <div class="box-body">  
            <div class="form-group">
                <label for="username">Username</label>
                <spring:input path="username" type="text" class="form-control" placeholder="Enter Username"/>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <spring:input path="email" type="email" class="form-control" placeholder="Enter Email"/>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <spring:input path="password" type="text" class="form-control" placeholder="Enter Password"/>
            </div>  
            <div class="form-group">
                <label for="roleId">Role Id</label>

                <spring:select path="roleId" class="form-control">
                    <spring:option value="0">Select Role</spring:option>
                    <c:forEach var="ro" items="${role}">
                        <spring:option value="${ro.getRoleId()}">${ro.getRoleName()}
                        </spring:option>
                    </c:forEach>
                </spring:select>
            </div> 
            <div class="box-footer">
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </spring:form>
    </div>
    <%@include file="../../footer.jsp" %>

