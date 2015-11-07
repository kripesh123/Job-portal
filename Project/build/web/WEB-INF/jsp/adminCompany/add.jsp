<%@include file="../../header.jsp" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<div class="box box-primary">
    <div class="box-header">
        <h3 class="box-title">ADD Company</h3>
    </div>
    <spring:form action="${pageContext.request.contextPath}/admin/company/save" method="post" commandName="Company">
        <div class="box-body">  
            <div class="form-group">
                <label for="companyName">Company Name</label>
                <spring:input path="companyName" type="text" class="form-control" placeholder="Enter Company Name" required="required"/>
            </div>
            <div class="form-group">
                <label for="companyLogo">Company Logo</label>
                <spring:input path="companyLogo" type="text" class="form-control" placeholder="Enter Company Logo" required="required"/>
            </div>
            <div class="form-group">
                <label for="companyDescription">Company Description</label>
                <spring:input path="companyDescription" type="text" class="form-control" placeholder="Enter Company Description" required="required"/>
            </div>  
            <div class="box-footer">
                <button type="submit" class="btn btn-primary">Submit</button>
                <a href="${pageContext.request.contextPath}/admin/company"class="btn btn-danger">Cancel</a>
            </div>
        </spring:form>
    </div>
    <%@include file="../../footer.jsp" %>

