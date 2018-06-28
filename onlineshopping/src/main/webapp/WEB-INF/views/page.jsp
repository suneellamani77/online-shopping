<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
   <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
   
   <spring:url var="css" value="/resources/css/" />
	<spring:url var="js" value="/resources/js/" />
	<spring:url var="images" value="/resources/images/" />
   
    <c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>
	
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    
    <meta name="_csrf" content="${_csrf.token}" >
    <meta name="_csrf_header" content="${_csrf.headerName}" >

    <title>Online Shopping -${title}</title>

    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">
    
    <link href="${css}/bootstrap-theme-readable.css" rel="stylesheet">
    
     <link href="${css}/jquery.dataTables.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${css}/myapp.css" rel="stylesheet">
    
    <script type="text/javascript">
    window.menu='${title}';
    window.contextRoot='${contextRoot}';
    </script>

  </head>

  <body>
  
  <div class="wrapper">

    <!-- Navigation -->
   <%@ include file="./shared/nav.jsp" %>
   
   

    <!-- Page Content -->
    
    <div class="content">
    <c:if test="${userClicksHome==true}">
    <%@ include file="home.jsp" %>
    </c:if>
    
    <!-- when user clicks on about us -->
    <c:if test="${userClicksAbout==true}">
    <%@ include file="about.jsp" %>
    </c:if>
    
    <!-- when user clicks on contact us -->
    <c:if test="${userClicksContact==true}">
    <%@ include file="contact.jsp" %>
    </c:if>
    
    <!-- when user clicks on All Produts  -->
    <c:if test="${userClicksAllProducts==true or userClicksCategoryProducts==true}">
    <%@ include file="listProducts.jsp" %>
    </c:if>
    
    <c:if test="${userClickShowProduct==true}">
    <%@ include file="singleProduct.jsp" %>
    </c:if>
    
    <c:if test="${userClickManageProducts==true}">
    <%@ include file="manageProducts.jsp" %>
    </c:if>
    
	</div>

    <!-- Footer -->
   	<%@ include file="./shared/footer.jsp" %>

    	<!-- Jquery-->
    <script src="${js}/jquery.min.js"></script>
    
       <!-- Jquery Validation -->
    <script src="${js}/jquery.validate.js"></script>
    
    
    <script src="${js}/bootstrap.bundle.min.js"></script>
    
 <script src="${js}/jquery.dataTables.js"></script>
 
 <script src="${js}/bootbox.min.js"></script>
 
	<!-- Included external js -->
	 <script src="${js}/myapp.js"></script>
	</div>
  </body>

</html>
