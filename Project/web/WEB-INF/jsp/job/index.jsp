<%-- 
    Document   : index
    Created on : Jun 20, 2015, 7:44:43 PM
    Author     : Kripesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../../header.jsp" %>

<div class="box">
    <div class="row">
        <div class="pull-right" style="margin-right:30px">
            <p>
                <br/>
                <a href="${pageContext.request.contextPath}/admin/job/add" class="btn btn-primary btn-xs"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Add</a>
            </p>
        </div>
            <form>
                <br/>
                 <div class="pull-right" style="margin-right:30px">
             <select name="company_id">
             <option value="">Select Company</option>
            <c:forEach var="co" items="${companies}">
                <option value="${co.getCompanyId()}" <c:if test="${param.company_id==co.getCompanyId()}"> selected="selected"</c:if> >${co.getCompanyName()}
                    </option>
            </c:forEach>
            </select>
            <input type="submit" class="btn btn-info btn-xs" name="Go" value="Go"/>
                 </div>
        </form>
    </div>
    <div class="box-header">
        <h3 class="box-title">Job Data Table With Full Features</h3>
    </div><!-- /.box-header -->
    <div class="box-body">
        <table id="example1" class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th>Job Id</th>
                    <th>Company</th>
                    <th>Job Title</th>
                    <th>Job Description</th>
                    <th>Posted Date</th>
                    <th>Posting Close Date</th>
                    <th>Status</th>    
                    <th>No. Applicants</th>
                    <th>Action</th>
                </tr>
            </thead>
            <c:if test="${jobs.size()==0}">
                <tr><td colspan="9">No Records Found</td></tr>
            </c:if>
            <c:forEach var="job" items="${jobs}">
                <tr>
                    <td>${job.getJobId()}</td>
                    <td>${job.getCompany().getCompanyName()}</td>        
                    <td>${job.getJobTitle()}</td>
                    <td>${job.getJobDescription()}</td>
                    <td>${job.getPostedDate()}</td>
                    <td>${job.getPostingCloseDate()}</td>
                    <td><c:if test="${job.getStatus()==false}">
                            Vacant
                        </c:if>
                        <c:if test="${job.getStatus()==true}">
                            Occupied
                        </c:if>
                    </td>
                    <td><a href="applicant">${job.getTotalApplicants()}</a></td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/job/edit?id=${job.getJobId()}"class="btn btn-success btn-xs"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>Edit</a>
                        <br/>
                        <br/>
                        <a href="${pageContext.request.contextPath}/admin/job/delete?id=${job.getJobId()}" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>Delete</a>
                    </td>
                </tr>
            </c:forEach>   
        </table>
    </div><!-- /.box-body -->
</div>       

<script>
    $(document).on('ready', function () {
        $('.btn-danger').on('click', function () {
            if (confirm('Do you want to Delete?') === false) {
                return false;
            }
        });
    });
</script>
<%@include file="../../footer.jsp" %>