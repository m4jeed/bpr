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
<mt:vTemplate title="Kunjungan List">
	<jsp:attribute name="content">
		      <div class="row">
		      	<div class="col-xs-12">
		          <div class="box">
		          	
		          	<div class="col-md-50">  
					    <div class="box-header with-border">
					      <h4 class="text-center">Kunjungan</h4>
					    </div> 
					</div>
					
					<div class="box-body">
					    <h4>Filter</h4>
						<form class="form-horizontal" action="${pageContext.request.contextPath}/searchKunjungan" method="post">
					       	<div class="box-body">
					       		<div class="col-md-12">
						        <div class="form-group">
						           <label class="col-sm-2 control-label">Marketing</label>
						           <div class="col-sm-3">
						             <input type="text" name="namaMarketing" class="form-control" autocomplete="off" placeholder="silahkan isi marketing">
						           </div>
						         </div>
						         <div class="form-group">
						           <label class="col-sm-2 control-label">Debitur</label>
						           <div class="col-sm-3">
						             <input type="text" name="namaDebitur" class="form-control" autocomplete="off" placeholder="silahkan isi debitur">
						           </div>
						         </div>
						         </div>
						         <div class="col-md-12">
						         <div class="form-group">
						           <label class="col-sm-2 control-label">Dari Tgl</label>
						           <div class="col-sm-3">
						             <input type="text" name="tglKunjungan" id="tglAwal" class="form-control" autocomplete="off"  placeholder="silahkan isi tanggal awal">
						           </div>
						         </div>
						         <div class="form-group">
						           <label class="col-sm-2 control-label">Sampai Tgl</label>
						           <div class="col-sm-3">
						             <input type="text" name="tglKunjungan" id="tglAkhir" class="form-control" autocomplete="off" placeholder="silahkan isi tanggal akhir">
						           </div>
						         </div>
						         </div>
					        </div>
				            <div class="col-sm-offset-2 col-sm-3">
					        	<button type="submit" class="btn btn-primary"><i class="fa fa-search"></i> Cari</button>
				            </div>
					    </form>
				    </div>
				    
				    <div class="box-header">
		          	  <h3 class="box-title">Data Kunjungan</h3>
			          <a href="${pageContext.request.contextPath}/newDataKunjungan" class="btn btn-success pull-right"><i class="fa fa-plus"></i> Tambah</a> 
			      	</div>
				    
		            <div class="box-body">
			            <table id="example2" class="table table-bordered table-striped">
			            	<thead>
				            	<tr>
				            		<c:forEach var="headerLoop" items="${export.headerList}">
				            			<th class="text-center">${headerLoop}</th>
				            		</c:forEach>
				                </tr>
			            	</thead>
			            	<tbody>
				            	<c:forEach var="dataLoop" items="${export.dataList}">
						            <tr>
						            	<c:forEach var="itemLoop" items="${dataLoop}">
							            	<c:choose>
											   <c:when test="${itemLoop.type == 'Date'}">
													<td class="text-center"><fmt:formatDate value="${itemLoop.value}" pattern="dd-MM-YYYY" /></td>
												</c:when>
											   <c:otherwise>
													<td><c:out value="${itemLoop.value}" /></td>
												</c:otherwise>
											</c:choose>
				            			</c:forEach>
						    			<td class="text-center">
							          	  	<a class="btn btn-info" title="Edit" href="${pageContext.request.contextPath}/editDataKunjungan?id=<c:out value='${dataLoop[0].value}' />"><i class="fa fa-edit"></i></a>
					          				<a class="btn btn-danger" title="Delete" href="${pageContext.request.contextPath}/deleteDataKunjungan?id=<c:out value='${dataLoop[0].value}' />" 
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
