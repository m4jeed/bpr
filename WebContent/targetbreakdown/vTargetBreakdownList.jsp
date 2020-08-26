<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<% //In case, if Admin session is not set, redirect to Login page
	if((request.getSession(false).getAttribute("role") != "admin") )
	{
	%>
	<jsp:forward page="/login/vLogin.jsp"></jsp:forward>
<%} %>
<mt:vTemplate title="Targetbreakdown List">
	<jsp:attribute name="content">
		      <div class="row">
		      	<div class="col-xs-12">
		          <div class="box">
		          	
		          	<div class="col-md-50">  
					    <div class="box-header with-border">
					      <h4 class="text-center">Target Breakdown</h4>
					    </div> 
					</div>
					<div class="box-body">
					    <h4>Filter</h4>
						<form class="form-horizontal" action="${pageContext.request.contextPath}/searchDataTargetbreakdown" method="post">
					       	<div class="box-body">
						        <div class="form-group">
						           <label class="col-sm-2 control-label">Aoid</label>
						           <div class="col-sm-3">
						             <input type="text" name="aoId" class="form-control" autocomplete="off" placeholder="silahkan isi aoid">
						           </div>
						         </div>
						         <div class="form-group">
						           <label class="col-sm-2 control-label">Type</label>
						           <div class="col-sm-3">
						             <input type="text" name="type" class="form-control" autocomplete="off" placeholder="silahkan isi type">
						           </div>
						         </div>
					        </div>
				            <div class="col-sm-offset-2 col-sm-3">
					        	<button type="submit" class="btn btn-primary"><i class="fa fa-search"></i> Cari</button>
				            </div>
					    </form>
				    </div>
		          
		          	<div class="box-header">
		          	  <h3 class="box-title">Data Target Breakdown</h3>
			          <a href="${pageContext.request.contextPath}/newDataTargetbreakdown" class="btn btn-success pull-right"><i class="fa fa-plus"></i> Tambah</a> 
			      	</div>
		            <div class="box-body">
			            <table id="example2" class="table table-bordered table-striped">
			            	<thead>
				            	<tr>
					                <th>Aoid</th>
					                <th>Type</th>
					                <th>Start Val</th>
					                <th>End Val</th>
					                <th>PCT</th>
					                <th class="text-center">Aksi</th>
					            </tr>
			            	</thead>
			            	<tbody>
				            	<c:forEach var="dataLoop" items="${resList}">
						            <tr>
						              <td><c:out value="${dataLoop.aoId}" /></td>
						          	  <td><c:out value="${dataLoop.type}" /></td>
					                  <td class="text-right"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${dataLoop.startVal}" /></td>
					                  <td class="text-right"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${dataLoop.endVal}" /></td>
					                  <td class="text-right"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${dataLoop.percentage}" /></td>
						          	  <td class="text-center">
						          	  	<a class="btn btn-info" title="Edit" href="${pageContext.request.contextPath}/editDataTargetbreakdown?id=<c:out value='${dataLoop.id}' />"><i class="fa fa-edit"></i></a>
				          				<a class="btn btn-danger" title="Delete" href="${pageContext.request.contextPath}/deleteDataTargetbreakdown?id=<c:out value='${dataLoop.id}' />" 
				          				onclick="return confirm('Anda yakin akan menghapus data ini.');">
				          				<i class="fa fa-trash"></i></a> 
						              </td>
						            </tr> 
					            </c:forEach>
			            	</tbody>
				        </table>   
		            </div>
		          </div>
		        </div>  
		      </div>
	</jsp:attribute>
</mt:vTemplate>