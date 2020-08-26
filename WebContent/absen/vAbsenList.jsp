<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%
	if((request.getSession(false).getAttribute("role") != "admin") && (request.getSession(false).getAttribute("role") != "member"))
	{
%>
	<jsp:forward page="/login/vLogin.jsp"></jsp:forward>
<%} %>
<mt:vTemplate title="Absensi List">
	<jsp:attribute name="content">
		      <div class="row">
		      	<div class="col-xs-12">
		          <div class="box">
		          	
		          	<div class="col-md-50">  
					    <div class="box-header with-border">
					      <h4 class="text-center">Absen</h4>
					    </div> 
					</div>
					<div class="box-body">
					    <h4>Filter</h4>
						<form class="form-horizontal" action="${pageContext.request.contextPath}/searchAbsen" method="post">
					       	<div class="box-body">
					       		<div class="col-md-12">
						        <div class="form-group">
						           <label class="col-sm-2 control-label">Nama</label>
						           <div class="col-sm-3">
						             <input type="text" name="nama" class="form-control" autocomplete="off" placeholder="silahkan isi nama">
						           </div>
						         </div>
						         <div class="form-group">
						           <label class="col-sm-2 control-label">Cabang</label>
						           <div class="col-sm-3">
						             <input type="text" name="cabang" class="form-control" autocomplete="off" placeholder="silahkan isi cabang">
						           </div>
						         </div>
						         </div>
						         <div class="col-md-12">
						         <div class="form-group">
						           <label class="col-sm-2 control-label">Dari Tgl</label>
						           <div class="col-sm-3">
						             <input type="text" name="tanggal" id="tgl-kunjungan" class="form-control" autocomplete="off">
						           </div>
						         </div>
						         <div class="form-group">
						           <label class="col-sm-2 control-label">Sampai Tgl</label>
						           <div class="col-sm-3">
						             <input type="text" name="tanggal" id="tgl-janji" class="form-control" autocomplete="off">
						           </div>
						         </div>
						         </div>
					        </div>
				            <div class="col-sm-offset-2 col-sm-3">
					        	<button type="submit" class="btn btn-primary"><i class="fa fa-search"></i> Cari</button>
				            </div>
					    </form>
				    </div>
				    
		            <div class="box-body">
			            <table id="example2" class="table table-bordered table-striped">
			            	<thead>
				            	<tr>
					                <th>Nama</th>
					                <th class="text-center">Tanggal</th>
					                <th class="text-center">Cabang</th>
					                <th class="text-center">Status</th>
					            </tr>
			            	</thead>
			            	<tbody>
				            	<c:forEach var="dataLoop" items="${resList}">
						            <tr>
						              <td><c:out value="${dataLoop.nama}" /></td>
						              <td class="text-center"><fmt:formatDate value="${dataLoop.tanggal}" pattern="dd-MM-YYYY" /></td>
						          	  <td class="text-center"><c:out value="${dataLoop.cabang}" /></td>
					                  <td><c:out value="${dataLoop.status}" /></td>
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
