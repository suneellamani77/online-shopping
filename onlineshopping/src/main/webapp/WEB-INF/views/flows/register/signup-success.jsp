<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ include file="../shared/flows-header.jsp" %>
<div class="container">
	
	<div class="row">
		<div class="col-sm-offset-4 col-sm-4">
			<div class="text-center">
				<h1>Welcome!</h1>
				<h3>onlineshopping.com</h3>
				<h6>You can use your email address as Username to login!</h6>
				<div>
				<a href="${contextRoot}/login" class="btn btn-success btn-lg" >Login Here</a>
				</div>
			</div>
		</div>
	</div>
	
</div>
<%@ include file="../shared/flows-footer.jsp"%>