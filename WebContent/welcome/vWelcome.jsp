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
	<link rel="shortcut icon" type="image/ico" href="${pageContext.request.contextPath}/assets/logobpr.jpg" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/bower_components/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/welcome.css">
		<div class="container">
            <div class="row">
            	<div class="section-padding">
	                <div class="col-md-8 col-lg-8 col-md-offset-2 col-lg-offset-2 col-sm-12 col-xs-12">
	                    <div class="w-content text-center">
	                        <img src="${pageContext.request.contextPath}/assets/logobpr.jpg" alt="" width="400px" height="200px">
	                        <h1>Welcome to begin</h1>
	
	                    </div>
	
	                </div>
                </div>

            </div>

        </div>
	</jsp:attribute>
</mt:vTemplate>