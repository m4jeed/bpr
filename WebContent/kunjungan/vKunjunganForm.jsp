<%@ page language="java" contentType="text/html; chargetEdit=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<% //In case, if Admin session is not getEdit, redirect to Login page
	if((request.getSession(false).getAttribute("role") != "admin") )
	{
	%>
	<jsp:forward page="/login/vLogin.jsp"></jsp:forward>
<%} %>
<mt:vTemplate title="Kunjungan Form">
	<jsp:attribute name="content">
    <div class="col-md-50">  
	    <div class="box box-default">
	        <form action="${pageContext.request.contextPath}/prosesDataKunjungan" method="post" class="form-horizontal" enctype="multipart/form-data">
	            
            <div class="box-header with-border">
            	<c:if test="${getEdit != null}">
                   <h3 class="box-title">Edit Kunjungan</h3>
                </c:if>
                <c:if test="${getEdit == null}">
                    <h3 class="box-title">Add New Kunjungan</h3>
                </c:if>
            </div>
		   	<div class="box-body">
			   	<div class="col-md-6">
		   			<div class="form-group">
			             <label class="col-sm-3 control-label">Tipe</label>
			             <div class="col-sm-5">
			               <input type="hidden" name="id" value="<c:out value='${getEdit.id}' />"  class="form-control" autocomplete="off">
			               <input type="text" name="tipe" value="<c:out value='${getEdit.tipe}' />" class="form-control" autocomplete="off" placeholder="Silahkan Isi tipe">
			             </div>
			        </div>
			        
			        <div class="form-group">
			             <label class="col-sm-3 control-label">Tanggal Kunjungan</label>
			             <div class="col-sm-5">
			               <input type="text" name="tglKunjungan" value="<c:out value='${getEdit.tglKunjungan}' />" id="tgl-kunjungan" class="form-control" autocomplete="off" placeholder="Silahkan Isi tanggal kunjungan">
			             </div>
			        </div>
			        
			        <div class="form-group">
			             <label class="col-sm-3 control-label">Marketing</label>
			             <div class="col-sm-5">
			               <input type="text" name="namaMarketing" value="<c:out value='${getEdit.namaMarketing}' />" class="form-control" autocomplete="off" placeholder="Silahkan Isi tipe">
			             </div>
			        </div>
			        
			        <div class="form-group">
			             <label class="col-sm-3 control-label">Debitur</label>
			             <div class="col-sm-5">
			               <input type="text" name="namaDebitur" value="<c:out value='${getEdit.namaDebitur}' />" class="form-control" autocomplete="off" placeholder="Silahkan Isi debitur">
			             </div>
			        </div>
			    
			        <div class="form-group">
			             <label class="col-sm-3 control-label">No. Pinjaman</label>
			             <div class="col-sm-5">
			               <input type="text" name="noPinjaman" value="<c:out value='${getEdit.noPinjaman}' />" class="form-control" autocomplete="off" placeholder="Silahkan Isi no.pinjaman">
			             </div>
			        </div>
			    </div>
			    <div class="col-md-6">
			        <div class="form-group">
			             <label class="col-sm-3 control-label">Hasil Kunjungan</label>
			             <div class="col-sm-5">
			               <input type="text" name="hasilKunjungan" value="<c:out value='${getEdit.hasilKunjungan}' />" class="form-control" autocomplete="off" placeholder="Silahkan Isi hasil kunjungan">
			             </div>
			        </div>
			        
			        <div class="form-group">
			             <label class="col-sm-3 control-label">Tanggal Janji</label>
			             <div class="col-sm-5">
			               <input type="text" name="tglJanji" value="<c:out value='${getEdit.tglJanji}' />" id="tgl-janji"  class="form-control" autocomplete="off" placeholder="Silahkan Isi tanggal janji">
			             </div>
			        </div>
			        
			        <div class="form-group">
			             <label class="col-sm-3 control-label">Petugas</label>
			             <div class="col-sm-5">
			               <input type="text" name="petugas" value="<c:out value='${getEdit.petugas}' />" class="form-control" autocomplete="off" placeholder="Silahkan Isi hasil petugas">
			             </div>
			        </div>
			      
			        <div class="form-group">
			          <label class="col-sm-3 control-label">Gambar</label>
			          <div class="col-sm-5">
			            <input type="file" name="gambar" id="IDimages" value="<c:out value='${getEdit.gambar}' />" class="form-control" onchange="LiatFoto();"/>
			            <c:if test="${getEdit != null}">
			            	<img src="dokumen/${getEdit.gambar}" id="buatpreview" style="width: 70px; height: 50px;" /><br>
			            </c:if>
			            <c:if test="${getEdit == null}">
			            	<img src="dokumen/user.jpg" id="buatpreview" style="width: 70px; height: 50px;" /><br>
			            </c:if>
			          </div>
			        </div>
			    </div>
			</div>
			<div class="modal-footer">
	            <div class="col-sm-offset-3 col-sm-5">
		              <button type="submit" class="btn btn-primary"><i class="fa fa-save"></i> Simpan</button>
		              <a href="${pageContext.request.contextPath}/kunjungan" style="color:white;" class="btn btn-warning pull-right" ><i class="fa fa-repeat"></i> Batal</a>
	            </div>
	        </div>
	    </div>
    </div>
    <script type="text/javascript">
	  function LiatFoto(){
	    var lihat = new FileReader();
	    lihat.readAsDataURL(document.getElementById("IDimages").files[0]);
	    lihat.onload = function (oFREvent){
	      document.getElementById("buatpreview").src = oFREvent.target.result;
	    };
	  };
	
	</script>
	</jsp:attribute>
</mt:vTemplate>
	