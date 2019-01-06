<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url var="css" value="/resources/css" />
<spring:url var="img" value="/resources/img" />
<spring:url var="js" value="/resources/js" />

<c:set var="contextRoot" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title }</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Bootstrap core CSS -->
    <link href="${css }/bootstrap.min.css" rel="stylesheet">
    <link href="${css }/bootstrap-readable-theme.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${css }/myapp.css" rel="stylesheet">
    
    <!-- Bootstrap DataTable -->
    <link href="${css }/dataTables.bootstrap.css" rel="stylesheet">
    
    <script>
    	window.menu = '${title}';
    	window.contextRoot = '${contextRoot}';
    </script>

</head>
  <body>

	<div class="wrapper">
	    <!-- Navigation -->
		<%@include file="../shared/flows-navbar.jsp" %>
	
		<!-- Page Content -->
		<div class="content" style="margin-top : 130px;">