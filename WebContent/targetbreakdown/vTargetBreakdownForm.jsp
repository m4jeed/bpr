<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<% //In case, if Admin session is not set, redirect to Login page
	if((request.getSession(false).getAttribute("role") != "admin") )
	{
	%>
	<jsp:forward page="/login/vLogin.jsp"></jsp:forward>
<%} %>
<mt:vTemplate title="Targetbreakdown form">
	<jsp:attribute name="content">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script src="${pageContext.request.contextPath}/assets/bower_components/jquery/dist/jquery.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/dist/css/skins/_all-skins.min.css">	
    <div class="col-md-50">  
	    <div class="box box-default">
	    	<c:if test="${getEdit != null}">
				<form action="${pageContext.request.contextPath}/updateDataTargetbreakdown" method="post" class="form-horizontal">
			</c:if>
			<c:if test="${getEdit == null}">
	            <form action="${pageContext.request.contextPath}/insertDataTargetbreakdown" method="post" class="form-horizontal">
	        </c:if>
            <div class="box-header with-border">
                <c:if test="${getEdit != null}">
                   <h3 class="box-title">Edit Target Breakdown</h3>
                </c:if>
                <c:if test="${getEdit == null}">
                    <h3 class="box-title">Add New Target Breakdown</h3>
                </c:if>
            </div>
		   	<div class="box-body">
		   			<div class="form-group">
		   				<c:if test="${getEdit != null}">
	                		<input type="hidden" name="id" value="<c:out value='${getEdit.id}' />"  class="form-control" required="required" autocomplete="off">
	            		</c:if>
			             <label class="col-sm-2 control-label">Aoid</label>
			             <div class="col-sm-3">
			               <input type="text" name="aoId" value="<c:out value='${getEdit.aoId}' />" class="form-control" required="required" autocomplete="off" placeholder="Silahkan Isi Aoid">
			             </div>
			        </div>
			        
			        <div class="form-group">
			             <label class="col-sm-2 control-label">Type</label>
			             <div class="col-sm-3">
			               <input type="text" name="type" value="<c:out value='${getEdit.type}' />" class="form-control" required="required" autocomplete="off" placeholder="Silahkan Isi Type">
			             </div>
			        </div>
			        
			        <div class="form-group">
			              <label class="col-sm-2 control-label">Start Val</label>
			              <div class="col-sm-3">
			                <input type="text" name="startVal" value ="<c:out value = "${getEdit.startVal}" />"  class="form-control" required="required" autocomplete="off" placeholder="Silahkan Isi Start Val">
			              </div>
			        </div>
			        
		   			<div class="form-group">
			              <label class="col-sm-2 control-label">End Val</label>
			              <div class="col-sm-3">
			                <input type="text" name="endVal" value ="<c:out value = "${getEdit.endVal}" />" class="form-control" required="required" autocomplete="off" placeholder="Silahkan Isi End Val">
			              </div>
		            </div>
		            
			        <div class="form-group">
			              <label class="col-sm-2 control-label">PCT</label>
			              <div class="col-sm-3">
			                <input type="text" name="percentage" value ="<c:out value = "${getEdit.percentage}" />" class="form-control" required="required" autocomplete="off" placeholder="Silahkan Isi PCT">
			              </div>
			        </div> 
			</div>
		   	<div class="modal-footer">
	            <div class="col-sm-offset-2 col-sm-3">
		              <button type="submit" class="btn btn-primary"><i class="fa fa-save"></i> Simpan</button>
		              <a href="${pageContext.request.contextPath}/targetbreakdown" style="color:white;" class="btn btn-warning pull-right" ><i class="fa fa-repeat"></i> Batal</a>
	            </div>
	        </div>
	    </div>
    </div>
	</jsp:attribute>
</mt:vTemplate>
	