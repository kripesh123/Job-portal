
<%@include file="../../header.jsp" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="box box-primary">
    <div class="box-header">
        <h3 class="box-title">Edit Company</h3>
    </div>
    <spring:form action="${pageContext.request.contextPath}/admin/company/update?id=${company.getCompanyId()}" method="post" commandName="Company">
        <div class="box-body">
            <div class="form-group">
                <label for="companyName">Company Name</label>
                <spring:input path="companyName" type="text" class="form-control" value = "${company.getCompanyName()}"/>
            </div>  
            <div class="form-group">
                <label for="companyDescription">Company Description</label>
                <spring:input path="companyDescription" type="text" class="form-control" value = "${company.getCompanyDescription()}"/>
            </div>
            <div class="form-group">
                <label for="companyLogo">Company Logo</label>
                <spring:input path="companyLogo" type="text" value = "${company.getCompanyLogo()}" class="form-control"/>
            </div>
            </div>
            <div class="box-footer">
                <button type="submit" class="btn btn-primary">Apply</button>
                <a href="${pageContext.request.contextPath}/admin/company"class="btn btn-danger">Cancel</a>
            </div>
        </spring:form>
    </div>
    <%@include file="../../footer.jsp" %>

