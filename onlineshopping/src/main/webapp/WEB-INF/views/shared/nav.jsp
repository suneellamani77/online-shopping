 <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
 
 <nav class="navbar navbar-expand-lg navbar-inverse fixed-top">
      <div class="container">
        <%-- <a class="navbar-brand" href="${contextRoot}/home" id="home">Online Shopping</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
          
        </button> --%>
        
         <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbarResponsive">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${contextRoot}/home">Online Shopping</a>
            </div>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <%-- <li class="nav-item" id="home">
              <a class="nav-link" href="${contextRoot}/home">Home
                <span class="sr-only">(current)</span>
              </a>
            </li> --%>
            <li class="nav-item" id="about">
              <a class="nav-link" href="${contextRoot}/about">About</a>
            </li>
            <li class="nav-item" id="contact">
              <a class="nav-link" href="${contextRoot}/contact">Contact</a>
            </li>
            
             <li class="nav-item" id="products">
              <a class="nav-link" href="${contextRoot}/show/all/products">View Products</a>
            </li>
            
            <sec:authorize access="hasAuthority('ADMIN')">
            <li class="nav-item" id="manageproducts">
              <a class="nav-link" href="${contextRoot}/manage/products">Manage Products</a>
            </li>
            </sec:authorize>
          </ul>
          
          <ul class="nav navbar-nav navbar-right">
          
          
          <sec:authorize access="isAnonymous()">
          <li class="nav-item" id="register">
              <a class="nav-link" href="${contextRoot}/register">Sign Up</a>
            </li>
            
            <li class="nav-item" id="login">
              <a class="nav-link" href="${contextRoot}/login">Login</a>
            </li>
            </sec:authorize>
            
            <sec:authorize access="isAuthenticated()">
            <li class="dropdown">
            	<a href="javascript:void(0)"
            	class="btn btn-default dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">
            	${userModel.fullName}
            	 <!-- <span class="caret"></span> -->
            	</a>
            	
            	<ul class="dropdown-menu">
            	
            	<sec:authorize access="hasAuthority('USER')">
            		<li>
            			<a href="${contextRoot}/cart">
            				<span class="glyphicon glyphicon-shopping-cart"></span>
            				<span class="badge">${userModel.cart.cartLines }</span>
            				- &#8377; ${userModel.cart.grandTotal}
            			</a>
            		</li>
            		</sec:authorize>
            		<li class="divider" role="seperator"></li>
            		
            		<li >
            			<a href="${contextRoot}/perform-logout">Logout</a>
            		</li>
            	</ul>
            	
            </li>
            </sec:authorize>
          </ul>
          
          
        </div>
      </div>
    </nav>
    
    <script type="text/javascript">
		window.userRole='${userModel.role}';
	</script>
    