
<%@include file="../../header.jsp" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="box box-primary">
    <div class="box-header">
        <br/>
        <h3 class="box-title">ADD SCHEDULE</h3>
    </div>
    
        <div class="box-body">
            
<spring:form action="${pageContext.request.contextPath}/admin/schedule/save" method="post" commandName="Schedule">
            <div class="form-group">
                <label for="applicantId">Applicant Id</label>
                
                <spring:select path="applicantId" class="form-control">
                    <spring:option value="0">Select Applicant</spring:option>
                    <c:forEach var="app" items="${applicants}">
                        <spring:option value="${app.getApplicantId()}">${app.getFirstName()} ${app.getLastName()}
                    </spring:option>
                    </c:forEach>
                </spring:select>
            </div> 
            <div class="form-group">
                <label for="scheduleDate">Schedule Date</label>
                <input type="date" class="form-control" name="schedule_date" placeholder="Enter Schedule Date "/>
            </div>
            <div class="form-group">
                <label for="scheduleTime">Schedule Time</label>
                <input type="time" class="form-control" name="schedule_time" placeholder="Enter Schedule Time"/>
            </div>
            <div class="form-group">
                <label for="interviewer">Interviewer</label>
                
                <spring:select path="interviewer" class="form-control">
                    <spring:option value="0" >Select Interviewer</spring:option>
                    <c:forEach var="role" items="${roles}">
                        <spring:option value="${role.getRoleId()}">${role.getRoleName()} 
                    </spring:option>
                    </c:forEach>
                </spring:select>
            </div> 
            <div class="form-group">
                <label for="messageForApplicant">Message For Applicant</label>
                <spring:input path="messageForApplicant" type="text" class="form-control" placeholder="Enter Message For Applicant"/>
            </div>
            <div class="form-group">
                <label for="messageForInterviewer">Message For Interviewer</label>
                <spring:input path="messageForInterviewer" type="text" class="form-control" placeholder="Enter Message For Interviewer"/>
            </div>
            <div class="form-group">
                <label for="scheduleStatus">Schedule Status</label>
                <spring:input path="scheduleStatus"  class="form-control" placeholder="Enter Schedule Status"/>
            </div>   
            <div class="form-group">
                <label for="remarks">Remarks</label>
                <spring:input path="remarks" class="form-control" placeholder="Enter Remarks"/>
            </div>
            <div class="box-footer">
                <button type="submit" class="btn btn-primary">Save</button>
                <a href="${pageContext.request.contextPath}/admin/schedule"class="btn btn-danger">Cancel</a>
            </div>
        </spring:form>

    
    
    </div>
    <%@include file="../../footer.jsp" %>

