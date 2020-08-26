<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<% //In case, if Admin session is not set, redirect to Login page
	if((request.getSession(false).getAttribute("role") == null))
	{
%>
	<jsp:forward page="/login/vLogin.jsp"></jsp:forward>
<%} %>
<mt:vTemplate title="Halaman Dashboard">
	<jsp:attribute name="content">
		<div class="row">
		      	<div class="col-xs-12">
		          <div class="box">
		          	
		          	<div class="col-md-50">  
					    <div class="box-header with-border">
					      <h4 class="text-center">Absen</h4>
					      <table>
					      <tbody>
					      	<c:forEach var="Loop" items="${listUser}">
			            	 <tr>
					      <td><c:out value="${Loop.username}" /></td>
					      </tr>
					      </c:forEach>
					      </tbody>
					      </table> 
					      
					      
<%-- 					     <b>${listUser.username }</b> --%>
					    </div> 
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