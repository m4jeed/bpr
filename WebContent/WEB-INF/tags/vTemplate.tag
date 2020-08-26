<%@ tag language="java" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ attribute name="title" required="true" rtexprvalue="true"%>
<%@ attribute name="content" fragment="true"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>${title}</title>
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="shortcut icon" type="image/ico" href="${pageContext.request.contextPath}/assets/logobpr.jpg" />
  
  <!-- Bootstrap 3.3.7 framework css yg digunakan-->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/bower_components/bootstrap/dist/css/bootstrap.min.css">
 
  <!-- Font Awesome -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/bower_components/font-awesome/css/font-awesome.min.css">
  
  <!-- Ionicons -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/bower_components/Ionicons/css/ionicons.min.css">
  
   <!-- bootstrap datepicker buat view kelender -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">
  
  <!-- Select2 buat option -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/bower_components/select2/dist/css/select2.min.css">
  
  <!-- DataTables buat list table -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
  
  <!-- Theme style, plugin punya AdminLTE-->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/dist/css/AdminLTE.min.css">
  
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/dist/css/skins/_all-skins.min.css">
  
  <!-- jQuery 3 plugin buat jalananin tampilan dinamis semua script javasecript-->
  <script src="${pageContext.request.contextPath}/assets/bower_components/jquery/dist/jquery.min.js"></script>
  
</head>


<body class="hold-transition skin-blue layout-top-nav">
<div class="wrapper">

  <header class="main-header">
    <nav class="navbar navbar-static-top">
      <div class="container">
        <div class="navbar-header">
         <% //In case, if Admin session is not set, redirect to Login page
		if((request.getSession(true).getAttribute("role") != null)){%>
			<a href="" class="navbar-brand">Welcome ${role}</a>
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
            <i class="fa fa-bars"></i>
          </button>
		<%} %>
        </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse pull-left" id="navbar-collapse">
          <ul class="nav navbar-nav">
		   <% if((request.getSession(true).getAttribute("master") == "1") ){ %>
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">Master<span class="caret"></span></a>
	            <ul class="dropdown-menu" role="menu">

	            	<% if((request.getSession(true).getAttribute("targetbreakdown") == "1") ){ %>
	              		<li><a href="${pageContext.request.contextPath}/targetbreakdown">Target Breakdown</a></li>
					<% } %>	
					
					<% if((request.getSession(true).getAttribute("kunjungan") == "1") ){ %>
	              		<li><a href="${pageContext.request.contextPath}/kunjungan">Kunjungan</a></li>
					<% } %>		

					<% if((request.getSession(true).getAttribute("user") == "1") ){ %>
				  		<li><a href="${pageContext.request.contextPath}/user">User</a></li>	
					<% } %>	
					
					<% if((request.getSession(true).getAttribute("usermenu") == "1") ){ %>
				  		<li><a href="${pageContext.request.contextPath}/usermenu">User Menu</a></li>              
					<% } %>	
					
	            </ul>
            </li>
            <% } %>
            
            <% if((request.getSession(true).getAttribute("tools") == "1") ){ %>
            <li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">Tools<span class="caret"></span></a>
	            <ul class="dropdown-menu" role="menu">
					<% if((request.getSession(true).getAttribute("absen") == "1") ){ %>
	                 <li><a href="${pageContext.request.contextPath}/absen">Absen</a></li>              
					<% } %>	

	            </ul>
            </li>
            <% } %>

            
           </ul>
        </div>
        <!-- /.navbar-collapse -->
        <!-- Navbar Right Menu -->
        <div class="navbar-custom-menu">
        	<ul class="nav navbar-nav">  
        		<li class="dropdown">
                  <% if((request.getSession(true).getAttribute("role") != null)) {%>
                   <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-user"></i>&nbsp;&nbsp;${role}<span class="caret"></span></a> 
                  <%} %>
                  <ul class="dropdown-menu" role="menu">
                        <li><a href="javascript:void(0)" onclick="showModalChangePassword()">Change Password</a></li>
            			<li><a href="logout">Logout</a></li>
                  </ul>
                </li>
         	</ul>
         </div>
        <!-- /.navbar-custom-menu -->
      </div>
      <!-- /.container-fluid -->
    </nav>
  </header>
  <!-- Full Width Column -->
  <div class="content-wrapper">
    <div class="container-fluid">
	      <section class="content">
	      	 <!-- / fungsi buat panggil page content-->
			<jsp:invoke fragment="content"></jsp:invoke>
	      </section>
      <!-- /.content -->
    </div>
    <!-- /.container -->
  </div>
  <!-- /.content-wrapper -->
  <footer class="main-footer">
    <div class="container">
      <div class="pull-right hidden-xs">
        <b>Version</b> 2.4.0
      </div>
      <strong>Copyright &copy; 2020 BPR Cahaya Fajar.</strong> All rights
      reserved.
    </div>
    <!-- /.container -->
  </footer>
</div>

<!-- Bootstrap 3.3.7 atau framework yangg digunakan-->
<script src="${pageContext.request.contextPath}/assets/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- AdminLTE atau templete bawaan -->
<script src="${pageContext.request.contextPath}/assets/dist/js/adminlte.min.js"></script>

<!-- Select2 untuk elect option -->
<script src="${pageContext.request.contextPath}/assets/bower_components/select2/dist/js/select2.full.min.js"></script>

<!-- bootstrap datepicker buat view tampilan kalender-->
<script src="${pageContext.request.contextPath}/assets/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>

<!-- DataTables buat list table-->
<script src="${pageContext.request.contextPath}/assets/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>


<script>
  $(function () {
    $("#example1").DataTable();
    $('#example2').DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": false,
      "ordering": true,
      "info": true,
      "autoWidth": false
    });
  });
</script>
<script type="text/javascript">
		$( document ).ready(function() {
		    $("#tgl-kunjungan").datepicker({ 
		        format: 'yyyy-mm-dd',
		        autoclose: true
		    });
		    $("#tgl-kunjungan").on("change", function () {
		        var fromdate = $(this).val();
// 		        alert(fromdate);
		    });
		}); 
	</script>
	<script type="text/javascript">
		$( document ).ready(function() {
		    $("#tgl-janji").datepicker({ 
		        format: 'yyyy-mm-dd',
		        autoclose: true
		    });
		    $("#tgl-janji").on("change", function () {
		        var fromdate = $(this).val();
		    });
		}); 
	</script>
	<script type="text/javascript">
	    //Date picker
	    $('#tglAwal').datepicker({
	      autoclose: true,
	      format: 'yyyy-mm-dd'
	      
	    });
	
	    $('#tglAkhir').datepicker({
	      autoclose: true,
	      format: 'yyyy-mm-dd',
	      startDate: '-3d'
	    });
	</script>

</body>
</html>

