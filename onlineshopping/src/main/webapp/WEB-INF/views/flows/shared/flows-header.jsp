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
    
    <script type="text/javascript">
    window.menu='${title}';
    window.contextRoot='${contextRoot}';
    </script>

  </head>

  <body>
  
  <div class="wrapper">

    <!-- Navigation -->
   
 	<%@ include file="flows-navbar.jsp" %>

    <!-- Page Content -->
    
    <div class="content">