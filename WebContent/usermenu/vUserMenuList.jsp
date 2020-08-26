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
<mt:vTemplate title="Usermenu List">
	<jsp:attribute name="content">
		<div class="row">
			<div class="col-xs-12">
		    	<div class="box">
		          	<div class="col-md-50">  
					    <div class="box-header with-border">
					      <h4 class="text-center">User Menu</h4>
					    </div> 
					</div>
					<div class="box-body">
					    <h4>Filter</h4>
						<form class="form-horizontal" action="${pageContext.request.contextPath}/searchUserMenu" method="post">
					       	<div class="box-body">
						        <div class="form-group">
						           <label class="col-sm-2 control-label">User Id</label>
						           <div class="col-sm-3">
						             <input type="text" name="userId" class="form-control" autocomplete="off" placeholder="silahkan isi user id">
						           </div>
						         </div>
						         <div class="form-group">
						           <label class="col-sm-2 control-label">Nama Menu</label>
						           <div class="col-sm-3">
						             <input type="text" name="menuName" class="form-control" autocomplete="off" placeholder="silahkan isi Nama Menu">
						           </div>
						         </div>
					        </div>
				            <div class="col-sm-offset-2 col-sm-3">
					        	<button type="submit" class="btn btn-primary"><i class="fa fa-search"></i> Cari</button>
				            </div>
					    </form>
				    </div>
		          
		          	<div class="box-header">
		          	  <h3 class="box-title">Data User Menu</h3>
			          <a href="${pageContext.request.contextPath}/newUserMenu" class="btn btn-success pull-right"><i class="fa fa-plus"></i> Tambah</a> 
			      	</div>
		            <div class="box-body">
			            <table id="example2" class="table table-bordered table-striped">
			            	<thead>
				            	<tr>
					                <th>User Id</th>
					                <th>Nama Menu</th>
					                <th>Sub Menu</th>
					                <th class="text-center">Aksi</th>
					            </tr>
			            	</thead>
			            	<tbody>
				            	<c:forEach var="dataLoop" items="${resList}">
						            <tr>
						              <td><c:out value="${dataLoop.userId}" /></td>
						          	  <td><c:out value="${dataLoop.menuName}" /></td>
					                  <td><c:out value="${dataLoop.subMenu}" /></td>
						          	  <td class="text-center">
						          	  	<a class="btn btn-info" title="Edit" href="${pageContext.request.contextPath}/editUserMenu?id=<c:out value='${dataLoop.id}' />"><i class="fa fa-edit"></i></a>
										<a class="btn btn-danger" title="Delete" href="${pageContext.request.contextPath}/deleteUserMenu?id=<c:out value='${dataLoop.id}' />" onclick="return confirm('Anda yakin akan menghapus data ini.');"><i class="fa fa-trash"></i></a>				          				
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
