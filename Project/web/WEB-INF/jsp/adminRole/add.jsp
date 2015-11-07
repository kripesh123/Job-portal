<%@include file="../../header.jsp" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<div class="box box-primary">
                <div class="box-header">
                  <h3 class="box-title">Add Role</h3>
                </div>
                <spring:form action="${pageContext.request.contextPath}/admin/role/save" commandName="Role" method="post">
                  <div class="box-body">
                    <div class="form-group">
                        <label for="roleName">Role Name</label>
                        <spring:input path="roleName" class="form-control" placeholder="Enter Role Name"/>
                    </div>
                  <div class="box-footer">
                    <button type="submit" class="btn btn-primary">Submit</button>
                    <a href="${pageContext.request.contextPath}/admin/role"class="btn btn-danger">Cancel</a>
                  </div>
                  </div>
                </spring:form>
              </div>
<%@include file="../../footer.jsp" %>
