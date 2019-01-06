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
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    
    <meta name="_csrf" content="${_csrf.token}">
	<meta name="_csrf_header" content="${_csrf.headerName}">

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
	    <%@include file="./templates/navbar.jsp" %>
	
		<!-- Page Content -->
		
		<div class="content">
			<!-- Loading the home content -->
			<c:if test="${userClickHome == true}">
		    	<%@include file="home.jsp" %>
			</c:if>
			
			<c:if test="${userClickAbout == true}">
		    	<%@include file="about.jsp" %>
			</c:if>
			
			<c:if test="${userClickContact == true}">
		    	<%@include file="contact.jsp" %>
			</c:if>
			
			<c:if test="${userClickAllProducts == true or userClickCategoryProducts == true}">
		    	<%@include file="listProducts.jsp" %>
			</c:if>
			
			<!-- Load only when user clicks show product -->
			<c:if test="${userClickShowProduct == true}">
		    	<%@include file="singleProduct.jsp" %>
			</c:if>
			
			<!-- Load only when user clicks manage product -->
			<c:if test="${userClickManageProduct == true}">
		    	<%@include file="manageProducts.jsp" %>
			</c:if>
			
			<!-- Load only when user clicks Cart -->
			<c:if test="${userClickShowCart == true}">
		    	<%@include file="cart.jsp" %>
			</c:if>
			
			
		</div>
	    
	    <!-- /.container -->
	
	    <!-- Footer -->
	    <%@include file="./templates/footer.jsp" %>
	
	    <!-- Bootstrap core JavaScript -->
	    <script src="${js }/jquery.js" ></script>
	    
	    <!--Bootstrap  -->
	    <script src="${js }/bootstrap.min.js"></script>
	    
	    <!-- Jquery Validate -->
	    <script src="${js }/jquery.validate.js"></script>
	    
	    <!-- Self coded javascript -->
	    <script src="${js }/myapp.js"></script>
	    
	    <!-- DataTables Plugin -->
	    <script src="${js }/jquery.dataTables.js"></script>
	    
	    <!-- DataTables Bootstrap -->
	    <script src="${js }/dataTables.bootstrap.js"></script>
	    
	    <!-- BootBox.js -->
	    <script src="${js }/bootbox.min.js"></script>
    </div>

  </body>

</html>