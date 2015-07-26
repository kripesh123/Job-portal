<%-- 
    Document   : index
    Created on : Jun 20, 2015, 4:49:59 PM
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
        <a href="${pageContext.request.contextPath}/admin/applicant/add" class="btn btn-primary btn-xs"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Add</a>
    </p>
</div>
    <form>
        <br/>
        <div class="pull-right" style="margin-right:30px">
            <select name="job_id">
                <option value="">Select Job Title</option>
                <c:forEach var="job" items="${jobs}">
                    <option value="${job.getJobId()}" <c:if test="${param.job_id==job.getJobId()}"> selected="selected"</c:if> >${job.getJobTitle()}
                    </option>
                </c:forEach>
            </select>
            <input type="submit" class="btn btn-info btn-xs" name="Go" value="Go"/>
        </div>
    </form>
</div>
    <div class="box-header">
        <h3 class="box-title">Applicant Data Table With Full Features</h3>
    </div><!-- /.box-header -->
    <div class="box-body">
        <table id="example1" class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Job Title</th> 
                    <th>Apply Date</th>
                    <th>Edit Date</th>
                    <th>Application Status</th>
                    <th>Remarks</th>
                    <th>Action</th>
                    <th>Details</th>
                </tr>
            </thead>
            <c:if test="${applicants.size()==0}">
                <tr><td colspan="9">No Records Found</td></tr>
            </c:if>
            <c:forEach var="app" items="${applicants}">
                <tr>
                    <td>${app.getApplicantId()}</td>
                    <td>${app.getFirstName()} ${app.getLastName()}</td>
                    <td>${app.getJob().getJobTitle()}</td>
                    <td>${app.getApplyDate()}</td>
                    <td>
                        <c:choose>
                            <c:when test="${app.getEditDate()==null}">
                                - - - - / - - / - -
                            </c:when>
                                <c:otherwise>
                                    ${app.getEditDate()}
                                </c:otherwise>
                        </c:choose>
                    </td>
                    <td>${app.getApplicationStatus()}</td>
                    <td>${app.getRemarks()}</td> 
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/applicant/edit?id=${app.getApplicantId()}"class="btn btn-success btn-xs"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>Edit</a>
                        <a href="${pageContext.request.contextPath}/admin/applicant/delete?applicant_id=${app.getApplicantId()}" id="btnDelete" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>Delete</a>
                    </td>
                    <td>
                        <button type="button"  class="btn btn-primary form-applicant" rel="${app.getApplicantId()}" >Details</button>
                        
                    </td>
                </tr>
            </c:forEach> 
        </table>
    </div><!-- /.box-body -->
</div>
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span></button>
                                        <h4 class="modal-title" rel="${app.getApplicantId()}" id="exampleModalLabel">Details</h4>
                                    </div>
                                    <div class="modal-body">
                                        <div id="applicant-detail"></div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                        
                                    </div>
                                </div>
                            </div>
                        </div>
    
       <script>
            $(document).on('ready',function(){
               $('.btn-danger').on('click',function(){
                  if(confirm('Do you want to Delete?')===false){
                       return false;
                  }
               }); 
               
                $('.form-applicant').on('click',function(){
                $this=$(this);
                $.get("applicant/detail/"+$this.attr('rel'),function(data){
                    $('#applicant-detail').html(data);
                    $('#exampleModal').modal({
                        keyboard: false
                    });
                });
                return false;
            });  
        });
           
                    
            
        </script>
<%@include file="../../footer.jsp" %>