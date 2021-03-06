<div class="container">
	<div class="row">
	
			<div class="col-xs-12">
			
				<ol class="breadcrumb">
				<li><a href="${contextRoot}/home">Home</a></li>
				<li><a href="${contextRoot}/show/all/products">Products</a></li>
				<li class="active">${product.name}</li>
				</ol>
			
			</div>
	
	</div>
	
	
	<div class="row">
			
			<div class="col-xs-12 col-sm-4">
			
			    <div class="thumbnail">
					<img src="${images}/${product.code}.jpg" class="img img-responsive" />						
			    </div>
			
			</div>
			
			
			<div class="col-xs-12 col-sm-4">
				
				<h3>${product.name}</h3>
				<hr/>
				
				<p>${product.description}</p>
				<hr/>
				
				<h4>Price: <strong>&#8377; ${product.unitPrice} /-</strong></h4>
				<hr/>
				
				
				<sec:authorize access="hasAuthority('USER')">
				<c:choose>
				
					<c:when test="${product.quantity <1}">
						<h6>Qty. Available : <strike> <span style="color: red">out of stack!!</span> </strike></h6>
						<hr/>
						<a href="javascript.void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span>Add Cart</a>
							&#160;
					</c:when>
					
					<c:otherwise>
					<h6>Qty. Available : ${product.quantity}</h6>
					<a href="${contextRoot}/cart/add/${product.id}/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span>Add Cart</a>
					&#160;
					</c:otherwise>
				</c:choose>
				</sec:authorize>
				
				<sec:authorize access="hasAuthority('ADMIN')">
				<a href="${contextRoot}/manage/${product.id}/product" class="btn btn-warning"><span class="glyphicon glyphicon-edit"></span>Edit</a>
							&#160;
				</sec:authorize>
				
				<a href="${contextRoot}/show/all/products" class="btn btn-primary">Back</a>
				
			</div>
			
			
	
	</div>
	
	
	

</div>