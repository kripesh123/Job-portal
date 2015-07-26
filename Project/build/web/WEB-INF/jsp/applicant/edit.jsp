
<%@include file="../../header.jsp" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="box box-primary">
    <div class="box-header">
        <h3 class="box-title">Edit APPLICANT</h3>
    </div>
    <spring:form action="${pageContext.request.contextPath}/admin/applicant/update?id=${applicant.getApplicantId()}" method="post" commandName="Applicant">
        <div class="box-body">
            <div class="form-group">
                <label for="jobId">Job</label>
                
                <spring:input path="jobId" class="form-control" type="text" value="${job.getJobTitle()}" disabled="true"/>
            </div>  
            <div class="form-group">
                <label for="firstName">First Name</label>
                <spring:input path="firstName" type="text" class="form-control" value = "${applicant.getFirstName()}" disabled="true"/>
            </div>
            <div class="form-group">
                <label for="lastName">Last Name</label>
                <spring:input path="lastName" type="text" value = "${applicant.getLastName()}" class="form-control" disabled="true"/>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <spring:input path="email" type="email" value = "${applicant.getEmail()}" class="form-control" disabled="true"/>
            </div>
            <div class="form-group">
                <label for="contactNo">Contact No</label>
                <spring:input path="contactNo" value = "${applicant.getContactNo()}" type="text" class="form-control" disabled="true"/>
            </div>
            
             <div class="form-group">
                <label for="applicationStatus">Application Status</label>
                    
                <spring:select path="applicationStatus" class="form-control">
                    <c:choose>
                        <c:when test="${applicant.getApplicationStatus()==null}">
                    <spring:option value="0">Select Status</spring:option>
                    <spring:option value="Pending">Pending</spring:option>
                    <spring:option value="Accepted">Accepted</spring:option>
                    <spring:option value="Rejected">Rejected</spring:option>
                    </c:when>
                    <c:otherwise>
                        <spring:option value="${applicant.getApplicationStatus()}">${applicant.getApplicationStatus()}</spring:option>
                        <c:if test="${applicant.getApplicationStatus()!='Pending'}">
                    <spring:option value="Pending">Pending</spring:option>
                    </c:if>
                        <c:if test="${applicant.getApplicationStatus()!='Accepted'}">
                    <spring:option value="Accepted">Accepted</spring:option>
                    </c:if>
                        <c:if test="${applicant.getApplicationStatus()!='Rejected'}">
                    <spring:option value="Rejected">Rejected</spring:option>
                    </c:if>
                    </c:otherwise>
                    </c:choose>
                </spring:select>
            </div>       
            <div class="form-group">
                <label for="remarks">Remarks</label>
                <spring:input path="remarks" class="form-control" value = "${applicant.getRemarks()}"/>
            </div>
            <div class="box-footer">
                <button type="submit" class="btn btn-primary">Apply</button>
                <a href="${pageContext.request.contextPath}/admin/applicant"class="btn btn-danger">Cancel</a>
            </div>
        </spring:form>
    </div>
    <%@include file="../../footer.jsp" %>

