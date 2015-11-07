
<%@include file="../../header.jsp" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="box box-primary">
    <div class="box-header">
        <h3 class="box-title">Edit Job</h3>
    </div>
    <spring:form action="${pageContext.request.contextPath}/admin/job/update?id=${job.getJobId()}" method="post" commandName="Job">
        <div class="box-body">
            <div class="form-group">
                <label for="companyId">Company</label>
                
                <spring:select path="companyId" class="form-control">
                    <spring:option value="0">${company.getCompanyName()}</spring:option>
                    <c:forEach var="company" items="${companies}">
                        <spring:option value="${company.getCompanyId()}">${company.getCompanyName()}
                    </spring:option>
                    </c:forEach>
                </spring:select>
            </div> 
            <div class="form-group">
                <label for="jobTitle">Job Title</label>
                <spring:input path="jobTitle" type="text" class="form-control" value = "${job.getJobTitle()}"/>
            </div>
            <div class="form-group">
                <label for="jobDescription">Job Description</label>
                <spring:input path="jobDescription" type="text" value = "${job.getJobDescription()}" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="postingCloseDate">Posting Close Date</label>
                <input type="date" value="${job.getPostingCloseDate()}" class="form-control" name="posting_close_date"/>
            </div>
            <div class="form-group">
                <label for="status">Status</label>
                
                <spring:select path="status" class="form-control">
                    <c:if test="${job.getStatus()==true}">
                        <spring:option value="1">Occupied</spring:option>
                        <spring:option value="0">Vacant</spring:option>
                    </c:if>
                        <c:if test="${job.getStatus()==false}">
                        <spring:option value="0">Vacant</spring:option>
                        <spring:option value="1">Occupied</spring:option>
                    </c:if>
                   
                    
                    
                </spring:select>
            </div> 
            <div class="box-footer">
                <button type="submit" class="btn btn-primary">Save</button>
                <a href="${pageContext.request.contextPath}/admin/job"class="btn btn-danger">Cancel</a>
            </div>
        </spring:form>
    </div>
    <%@include file="../../footer.jsp" %>

