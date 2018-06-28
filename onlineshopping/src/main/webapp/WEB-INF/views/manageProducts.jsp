<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<div class="container">

	<div class="row">
		
		<c:if test="${! empty message}">
		<div class="col-sm-12"> 
			<div class="alert alert-success alert-dismissible">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				${message}
			</div>
		</div>
	</c:if>
	
		<div class="col-md-offset-2 col-md-8">
		
			<div class="panel panel-primary">
				
				<div class="panel-heading">
					<h4>Product Management</h4>
				</div>
				
				<div class="panel-body">
					
					<!-- Form Element -->
					<sf:form action="${contextRoot}/manage/products" method="POST" class="form-horizontal" modelAttribute="product" enctype="multipart/form-data">
					
						<div class="form-group">
							
							<label class="control-label col-md-4" for="name">Product Name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="name" placeholder="Enter Product Name" class="form-control" />
								<sf:errors path="name" cssClass="help-block" element="em" />
							</div>
						
						</div>
						
						
						<div class="form-group">
							
							<label class="control-label col-md-4" for="brand">Brand Name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="brand" id="brand" placeholder="Enter Brand Name" class="form-control" />
								<sf:errors path="brand" cssClass="help-block" element="em" />
							</div>
						
						</div>
						
						<div class="form-group">
							
							<label class="control-label col-md-4" for="description">Product Description:</label>
							<div class="col-md-8">
								<sf:textarea rows="3"  path="description" id="description" placeholder="Enter Product Description" class="form-control" ></sf:textarea>
								<sf:errors path="description" cssClass="help-block" element="em" />
							</div>
						
						</div>
						
						
						<div class="form-group">
							
							<label class="control-label col-md-4" for="unitPrice">Unit Price:</label>
							<div class="col-md-8">
								<sf:input type="number" path="unitPrice" id="unitPrice" placeholder="Enter Unit Price" class="form-control" />
								<sf:errors path="unitPrice" cssClass="help-block" element="em" />
							</div>
						
						</div>
						
						
						<div class="form-group">
							
							<label class="control-label col-md-4" for="quantity">Quantity Available:</label>
							<div class="col-md-8">
								<sf:input type="number" path="quantity" id="quantity" placeholder="Enter Unit Price" class="form-control" />
							</div>
						
						</div>
						
						<!-- file Upload -->
						<div class="form-group">
							
							<label class="control-label col-md-4" for="quantity">Select Image:</label>
							<div class="col-md-8">
								<sf:input type="file" path="file" id="file" class="form-control" />
								<sf:errors path="file" cssClass="help-block" element="em" />
							</div>
						
						</div>
						
						
						<div class="form-group">
							
							<label class="control-label col-md-4" for="quantity">Select Category:</label>
							<div class="col-md-8">
								<sf:select class="form-control" id="categoryId" path="categoryId" style="height: 40px;line-height: 40px;"
								items="${categories}"
								itemLabel="name"
								itemValue="id"
								/>
								
								<c:if test="${product.id==0 }">
								<br>
								<div class="text-right">
								<button type="button" data-toggle="modal" data-target="#myCategoryModal" class="btn btn-warning btn-sm">
								Add Category</button>
								</div>
								 </c:if>
								
							</div>
						
						</div>
						
						
						
						
						<div class="form-group">
							
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" name="submit" id="submit" value="Submit" class="btn btn-primary" />
								
								<sf:hidden path="id"/>
								<sf:hidden path="code"/>
								<sf:hidden path="supplierId"/>
								<sf:hidden path="purchases"/>
								<sf:hidden path="views"/>
								<sf:hidden path="active"/>
							</div>
						
						</div>
					
					
					</sf:form>
					
					
				</div>
				
			</div>
		
		</div>
	
	</div>
	
	
	<div class="row">
	
		<div class="col-sm-12">
			<h3>Available Products</h3>
			<hr/>		
		</div>
		
		<div class="col-sm-12">
			
			
			<div class="container-fluid">
				
				<div class="table-responsive">
					
						<table id="adminProducutsTable" class="table table-striped table-bordered">
							<thead>
								<tr>
								<th>Id</th>
								<th>&#160;</th>
								<th>Name</th>
								<th>Brand</th>
								<th>Quantity</th>
								<th>Unit Price</th>
								<th>Active</th>
								<th>Edit</th>
								</tr>
							</thead>
							
							<%-- <tbody>
								<tr>
								<td>1</td>	
								<td>
								<img alt="" src="${contextRoot}/resources/images/PRDABC123DEFX.jpg" class="adminDataTableImg">
								</td>
								<td>iPhone 5s</td>
								<td>apple</td>
								<td>5</td>
								<td>18000.00</td>
								<td>
									<label class="switch">
									<input type="checkbox" checked="checked" value="1">
									<div class="slider"></div>
									</label>
								</td>
								<td>
								<a href="${contextRoot}/manage/4/product" class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></a>
								</td>
								</tr>
								
								<tr>
								<td>4</td>	
								<td>
								<img alt="" src="${contextRoot}/resources/images/PRDMNO123PQRX.jpg" class="adminDataTableImg">
								</td>
								<td>MackBook PRo</td>
								<td>apple</td>
								<td>5</td>
								<td>54000.00</td>
								<td>
									<label class="switch">
									<input type="checkbox" value="4">
									<div class="slider"></div>
									</label>
								</td>
								<td>
								<a href="${contextRoot}/manage/4/product" class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></a>
								</td>
								</tr>
							</tbody> --%>
							
							
							<tfoot>
								<tr>
								<th>Id</th>
								<th>&#160;</th>
								<th>Name</th>
								<th>Brand</th>
								<th>Quantity</th>
								<th>Unit Price</th>
								<th>Active</th>
								<th>Edit</th>
								</tr>
							</tfoot>
							
							
						</table>
					
				</div>
				
			</div>
				
				
				
			</div>
			
		</div>
	</div>
	

	<div class="modal fade" id="myCategoryModal" role="dialog">

		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<!-- Heading -->
				<div class="modal-header">
					<button type="button" data-dismiss="modal" class="close">
					<span>&times;</span> </button>
					<h4 class="modal-title">Add New Category</h4>
				</div>
				
				<div class="modal-body">
				<!-- Form ELement -->
				
				<sf:form id="categoryForm" modelAttribute="category" action="${contextRoot}/manage/category" method="POST" class="form-horizontal" >
					<div class="form-group">
						<label class="col-md-4 cntrol-label" for="category_name">Name</label>
						<div class="col-md-8">
							<sf:input path="name" id="category_name" type="text" class="form-control" placeholder="Enter Category Name" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-4 cntrol-label" for="category_description">Description</label>
						<div class="col-md-8">
							<sf:textarea rows="3" path="description" id="category_description"  class="form-control" placeholder="Category Description" />
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-md-offset-4 col-md-8">
							<input type="submit" name="submit" value="submit" class="btn btn-primary" />
						</div>
					</div>
					
				</sf:form>
				
				</div>
				
			</div>	
				
			
		</div>

	</div>


