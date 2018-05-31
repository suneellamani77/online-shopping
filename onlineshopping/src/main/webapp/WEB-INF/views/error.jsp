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

    <title>Online Shopping -${title}</title>

    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">
    
    <link href="${css}/bootstrap-theme-readable.css" rel="stylesheet">
    
     <link href="${css}/jquery.dataTables.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${css}/myapp.css" rel="stylesheet">
    
    <!-- <script type="text/javascript">
    window.menu='${title}';
    window.contextRoot='${contextRoot}';
    </script> -->

  </head>

  <body>
  
  <div class="wrapper">

  <nav class="navbar navbar-expand-lg navbar-inverse fixed-top">
      <div class="container" style="display: flow-root">
      		<div class="navbar-header">
        		<a class="navbar-brand" href="${contextRoot}/home" id="home">Home</a>
        	</div>
        </div>
        </nav>
   
    <!-- Page Content -->
   
    <div class="content">
    
    	<div class="container">
    			
    			<div class="row">
    			
    				<div class="col-xs-12">
    				
    					<div class="jumbotron">
    					
    						<h1>${errorTitle}</h1>
    						<!-- <h1> The Page is not constructed!</h1> -->
    						<hr/>
    						
    						<blockquote style="word-wrap:break-word;">
    							${errorDescription}
    						</blockquote>
    					</div>
    			
    				</div>
    				
    			</div>
    			
    	</div>
    
	</div>

    <!-- Footer -->
   	<%@ include file="./shared/footer.jsp" %>

	</div>
  </body>

</html>
