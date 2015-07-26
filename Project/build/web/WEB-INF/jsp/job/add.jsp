<%@include file="../../header.jsp" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="box box-primary">
    <div class="box-header">
        <h3 class="box-title">ADD JOB</h3>
    </div>
    <spring:form action="${pageContext.request.contextPath}/admin/job/save" method="post" commandName="Job">
        <div class="box-body">
            <div class="form-group">
                <label for="companyId">Company Id</label>

                <spring:select path="companyId" class="form-control">
                    <spring:option value="0">Select Company</spring:option>
                    <c:forEach var="co" items="${companys}">
                        <spring:option value="${co.getCompanyId()}">${co.getCompanyName()}
                        </spring:option>
                    </c:forEach>
                </spring:select>
            </div>     
            <div class="form-group">
                <label for="jobTitle">Job Title</label>
                <spring:input path="jobTitle" type="text" class="form-control" placeholder="Enter Job Title"/>
            </div>
            <div class="form-group">
                <label for="jobDescription">Job Description</label>
                <spring:input path="jobDescription" type="text" class="form-control" placeholder="Enter Job Description"/>
            </div>
          <div class="form-group">
                <label for="postingCloseDate">Posting Close Date</label>
                <input type="date" class="form-control" name = "posting_close_date" placeholder="Enter Posting Close Date"/>
            </div>

           <div class="form-group">
                <label for="status">Status</label>
                
                <spring:select path="status" class="form-control">
                    <spring:option value="#">Select Status</spring:option>
                    <spring:option value="0">Vacant</spring:option>
                    <spring:option value="1">Occupied</spring:option>
                    
                </spring:select>
            </div> 

            <div class="box-footer">
                <button type="submit" class="btn btn-primary">Submit</button>
                <a href="${pageContext.request.contextPath}/admin/job"class="btn btn-danger">Cancel</a>
            </div>
        </spring:form>
    </div>
    <%@include file="../../footer.jsp" %>

