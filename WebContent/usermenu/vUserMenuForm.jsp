<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<% 
	if((request.getSession(false).getAttribute("role") != "admin") )
	{
%>
	<jsp:forward page="/login/vLogin.jsp"></jsp:forward>
<%} %>
<mt:vTemplate title="Usermenu form">
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
				<form action="${pageContext.request.contextPath}/updateUserMenu" method="post" class="form-horizontal">
			</c:if>
			<c:if test="${getEdit == null}">
	            <form action="${pageContext.request.contextPath}/insertUserMenu" method="post" class="form-horizontal">
	        </c:if>
            <div class="box-header with-border">
                <c:if test="${getEdit != null}">
                   <h3 class="box-title">Edit User Menu</h3>
                </c:if>
                <c:if test="${getEdit == null}">
                    <h3 class="box-title">Add New User Menu</h3>
                </c:if>
            </div>
		   	<div class="box-body">
		   		<c:if test="${getEdit != null}">
	   			<div class="form-group">
		             <label class="col-sm-2 control-label">User Id</label>
		             <div class="col-sm-3">
		               <input type="hidden" name="id" value="<c:out value='${getEdit.id}' />"  class="form-control" autocomplete="off">
		               <input type="text" name="userId" value="<c:out value='${getEdit.userId}' />" class="form-control" readonly>
		             </div>
		        </div>
		        </c:if>
		        
		        <c:if test="${getEdit == null}">
	   			<div class="form-group">
		             <label class="col-sm-2 control-label">User Id</label>
		             <div class="col-sm-3">
		               <input type="text" name="userId" class="form-control" required="required" autocomplete="off" placeholder="Silahkan Isi User Id">
		             </div>
		        </div>
		        </c:if>
		        
		        <div class="form-group">
		             <label class="col-sm-2 control-label">Nama Menu</label>
		             <div class="col-sm-3">
		               <input type="text" name="menuName" value="<c:out value='${getEdit.menuName}' />" class="form-control" required="required" autocomplete="off" placeholder="Silahkan Isi Nama Menu">
		             </div>
		        </div>
		        
		        <div class="form-group">
		              <label class="col-sm-2 control-label">Sub Menu</label>
		              <div class="col-sm-3">
		                <input type="text" name="subMenu" value ="<c:out value = "${getEdit.subMenu}" />"  class="form-control" required="required" autocomplete="off" placeholder="Silahkan Isi Sub Menu">
		              </div>
		        </div>
			</div>
		   	<div class="modal-footer">
	            <div class="col-sm-offset-2 col-sm-3">
		              <button type="submit" class="btn btn-primary"><i class="fa fa-save"></i> Simpan</button>
		              <a href="${pageContext.request.contextPath}/usermenu" style="color:white;" class="btn btn-warning pull-right" ><i class="fa fa-repeat"></i> Batal</a>
	            </div>
	        </div>
	    </div>
    </div>
	</jsp:attribute>
</mt:vTemplate>