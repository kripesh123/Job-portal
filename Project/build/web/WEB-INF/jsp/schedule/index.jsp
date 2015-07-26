<%-- 
    Document   : index
    Created on : Jun 20, 2015, 8:23:35 PM
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
                <a href="${pageContext.request.contextPath}/admin/schedule/add" class="btn btn-primary btn-xs"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Add</a>
            </p>
        </div>
        <form>
            <br/>
            <div class="pull-right" style="margin-right:30px">
                <select name="interviewer">
                    <option value="">Select Interviewer</option>
                    <c:forEach var="role" items="${roles}">
                        <option value="${role.getRoleId()}" <c:if test="${param.role_id==role.getRoleId()}"> selected="selected"</c:if> >${role.getRoleName()}
                            </option>
                    </c:forEach>
                </select>
                <input type="submit" class="btn btn-info btn-xs" name="Go" value="Go"/>
            </div>
        </form>
    </div>
    <div class="box-header">
        <h3 class="box-title">Schedule Data Table With Full Features</h3>
    </div><!-- /.box-header -->
    <div class="box-body">
        <table id="example1" class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th>Schedule Id</th>    
                    <th>Applicant</th>
                    <th>Interviewer</th>
                    <th>Message For Applicant</th>
                    <th>Message For Interviewer</th>  
                    <th>Schedule Date</th>
                    <th>Schedule Time</th>
                    <th>Action</th>
                    <th>Details</th>
                </tr>
            </thead>
            <c:if test="${schedule.size()==0}">
                <tr><td colspan="9">No Records Found</td></tr>
            </c:if>
            <c:forEach var="sch" items="${schedule}">
                <tr>   
                    <td>${sch.getScheduleId()}</td>
                    <td>${sch.getApplicant().getFirstName()} ${sch.getApplicant().getLastName()}</td>
                    <td>${sch.getRole().getRoleName()}</td>
                    <td>${sch.getMessageForApplicant()}</td>
                    <td>${sch.getMessageForInterviewer()}</td>     
                    <td>
                        <c:choose>
                            <c:when test="${sch.getScheduleDate()==null}">
                                ----/--/--
                            </c:when>
                            <c:otherwise>
                                ${sch.getScheduleDate()}
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${sch.getScheduleTime()==null}">
                                00:00--
                            </c:when>
                            <c:otherwise>
                                ${sch.getScheduleTime()}
                            </c:otherwise>
                        </c:choose>
                    </td>

                    <td>
                        <a href="${pageContext.request.contextPath}/admin/schedule/edit?id=${sch.getScheduleId()}"class="btn btn-success btn-xs"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>Edit</a>
                        <br/>
                        <br/>
                        <a href="${pageContext.request.contextPath}/admin/schedule/delete?id=${sch.getScheduleId()}" id="btnDelete" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>Delete</a>
                    </td>

                    <td>
                        <button type="button"  class="btn btn-primary form-schedule" rel="${sch.getScheduleId()}">Details</button>

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
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" rel="${sch.getScheduleId()}" id="exampleModalLabel">Details</h4>
            </div>
            <div class="modal-body">
                <div id="schedule-detail"></div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

            </div>
        </div>
    </div>
</div>

<script>
    $(document).on('ready', function () {
        $('.btn-danger').on('click', function () {
            if (confirm('Do you want to Delete?') === false) {
                return false;
            }
        });
        
        
         $('.form-schedule').on('click',function(){
                $this=$(this);
                $.get("schedule/detail/"+$this.attr('rel'),function(data){
                    $('#schedule-detail').html(data);
                    $('#exampleModal').modal({
                        keyboard: false
                    });
                });
                return false;
            });  
    });
</script>
<%@include file="../../footer.jsp" %>