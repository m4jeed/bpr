<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
		<link rel="shortcut icon" type="image/ico" href="${pageContext.request.contextPath}/assets/logobpr.jpg" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/bower_components/bootstrap/dist/css/bootstrap.min.css">
		<!-- Font Awesome -->
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
		<!-- Ionicons -->
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
		<!-- Theme style -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/dist/css/AdminLTE.min.css">
		<!-- iCheck -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/iCheck/square/green.css">
	</head>
	
	<body class="hold-transition login-page">
		<div class="login-box">
		  <div class="login-logo">
		    <a href="#"><b>Halaman</b>Login</a>
		  </div>
		  <!-- /.login-logo -->
		  <div class="login-box-body">
		    <p class="login-box-msg">Sign in to start your session</p>
		    <core:if test="${not empty pesan}">
	            <div class="alert alert-danger alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden='true'></span></button>
					<span><%=(request.getAttribute("pesan") == null) ? "" : request.getAttribute("pesan")%></span>
				</div>
            </core:if>
            
<%--             <span style="color:red"><%=(request.getAttribute("pesan") == null) ? "" : request.getAttribute("pesan")%></span> --%>
		    <form action="<%=request.getContextPath()%>/log" method="post">
		      <div class="form-group has-feedback">
		        <input type="text" name="username" class="form-control" placeholder="Username"/>
		        <span class="glyphicon glyphicon-user form-control-feedback"></span>
		      </div>
		      <div class="form-group has-feedback">
		        <input type="password" name="password" class="form-control" placeholder="Password">
		        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
		      </div>
		      <div class="row">
		      	<div class="col-xs-8">
                </div>
		        <div class="col-xs-4">
		          <button type="submit" class="btn btn-primary btn-block btn-flat"><i class="fa fa-unlock"></i> Sign In</button>
		        </div>
		      </div>
		    </form>
		  </div>
		  <!-- /.login-box-body -->
		</div>
		<script src="${pageContext.request.contextPath}/assets/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
		<!-- iCheck -->
		<script src="${pageContext.request.contextPath}/assets/plugins/iCheck/icheck.min.js"></script>
		<script>
		  $(function () {
		    $('input').iCheck({
		      checkboxClass: 'icheckbox_square-blue',
		      radioClass: 'iradio_square-blue',
		      increaseArea: '20%' // optional
		    });
		  });
		</script>
	</body>
</html>