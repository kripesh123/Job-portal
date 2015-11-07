
<%@include file="../../header.jsp" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="box box-primary">
    <div class="box-header">
        <h3 class="box-title">ADD APPLICANT</h3>
    </div>
    <spring:form action="${pageContext.request.contextPath}/admin/applicant/save" method="POST" enctype="multipart/form-data" commandName="Applicant">
        <div class="box-body">
            <div class="form-group">
                <label for="jobId">Job Id</label>
                
                <spring:select path="jobId" class="form-control">
                    <spring:option value="0">Select Job</spring:option>
                    <c:forEach var="job" items="${jobs}">
                        <spring:option value="${job.getJobId()}">${job.getJobTitle()}
                    </spring:option>
                    </c:forEach>
                </spring:select>
            </div> 
            <div class="form-group">
                <label for="firstName">First Name</label>
                <spring:input path="firstName" type="text" class="form-control" placeholder="Enter First Name"/>
            </div>
            <div class="form-group">
                <label for="lastName">Last Name</label>
                <spring:input path="lastName" type="text" class="form-control" placeholder="Enter Last Name"/>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <spring:input path="email" type="email" class="form-control" placeholder="Enter Email"/>
            </div>
            <div class="form-group">
                <label for="contactNo">Contact No</label>
                <spring:input path="contactNo" type="text" class="form-control" placeholder="Enter Contact No"/>
            </div>
            <div class="form-group">
                <label for="coverLetter">Cover Letter</label>
                <input type="file" name="file" id="coverletter"><br /> 
        Name1: <input type="text" name="name"><br /> <br /> 
        
            </div>
            <div class="form-group">
                <label for="resume">Resume</label>
                File2 to upload: <input type="file" name="file" id="resume"><br /> 
        Name2: <input type="text" name="name"><br /> <br />
                
            </div>
            <div class="box-footer">
                <button type="submit" class="btn btn-primary">Apply</button>
                <a href="${pageContext.request.contextPath}/admin/applicant"class="btn btn-danger">Cancel</a>
            </div>
        </spring:form>
    </div>
    <%@include file="../../footer.jsp" %>

