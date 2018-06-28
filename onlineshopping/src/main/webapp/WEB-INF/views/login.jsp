<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css/" />
<spring:url var="js" value="/resources/js/" />
<spring:url var="images" value="/resources/images/" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
		<nav class="navbar navbar-expand-lg navbar-inverse fixed-top"
			role="navigation">
			<div class="container" style="display: flow-root">
				<div class="navbar-header">
					<a class="navbar-brand" href="${contextRoot}/home">Online
						Shopping</a>
				</div>
			</div>
		</nav>


		<!-- Page Content -->

		<div class="content">

			<div class="container">
			
				<div class="row">
				
				<!-- This will be displayed if credential goes wrong -->
				<c:if test="${! empty message}">
					<div class="col-md-offset-3 col-md-6">
						<div class="alert alert-danger ">
						${message}
						</div>
					</div>
				</c:if>
				
				<!-- This will be displayed if user Logged out -->
				<c:if test="${! empty logout}">
					<div class="col-md-offset-3 col-md-6">
						<div class="alert alert-success ">
						${logout}
						</div>
					</div>
				</c:if>
				
				
					<div class="col-md-offset-3 col-md-6">

						<div class="panel panel-primary">
							<div class="panel-heading">
								<h4>Login</h4>
							</div>

							<div class="panel-body">
								<form action="${contextRoot}/login" method="POST"
									class="form-horizontal" id="loginForm">

									<div class="form-group">
										<label class="col-md-4 control-label">Email:</label>
										<div class="col-md-8">
											<input type="text" name="username" id="username"
												class="form-control">
										</div>
									</div>

									<div class="form-group">
										<label class="col-md-4 control-label">Password:</label>
										<div class="col-md-8">
											<input type="password" name="password" id="password"
												class="form-control">
										</div>
									</div>

									<div class="form-group">
										<div class="col-md-offset-4 col-md-8">
											<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
											<input type="submit" value="Login" class="btn btn-primary">
										</div>
									</div>

								</form>
							</div>

							<div class="panel-footer">
								<div class="text-right">
									New User - <a href="${contextRoot}/register">Register Here</a>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>








		</div>

		<!-- Footer -->
		<%@ include file="./shared/footer.jsp"%>

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
