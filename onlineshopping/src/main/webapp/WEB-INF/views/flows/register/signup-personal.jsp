		<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
   		<%@ include file="../shared/flows-header.jsp" %>
   		
   		<div class="container">
   			
   			<div class="row">
   				<div class="col-md-offset-3 col-md-6">
   					
   					<div class="panel panel-primary">
   					
   						<div class="panel-heading">
   							<h4>Sign Up - Personal </h4>
   						</div>
   						
   						<div class="panel-body">
   						
   						<sf:form method="POST" class="form-horizontal" id="registerForm" modelAttribute="user">
   						
   						<div class="form-group">
   							<label class="col-md-4 control-label" for="firstName">First Name</label>
   							<div class="col-md-8">
   								<sf:input type="text" path="firstName" id="firstName" class="form-control" placeholder="First Name"/>
   								<sf:errors path="firstName" cssClass="help-block" element="em" />
   							</div>
   						</div>
   						
   						<div class="form-group">
   							<label class="col-md-4 control-label" for="lastName">Last Name</label>
   							<div class="col-md-8">
   								<sf:input type="text" path="lastName" id="lastName" class="form-control" placeholder="last Name"/>
   								<sf:errors path="lastName" cssClass="help-block" element="em" />
   							</div>
   						</div>
   						
   						<div class="form-group">
   							<label class="col-md-4 control-label" for="email">Email</label>
   							<div class="col-md-8">
   								<sf:input type="text" path="email" id="email" class="form-control" placeholder="abc@zyx.com"/>
   								<sf:errors path="email" cssClass="help-block" element="em" />
   							</div>
   						</div>
   						
   						<div class="form-group">
   							<label class="col-md-4 control-label" for="contactNumber">Contact Number</label>
   							<div class="col-md-8">
   								<sf:input type="text" path="contactNumber" id="contactNumber" class="form-control" placeholder="xxxxxxxxxx"/>
   								<sf:errors path="contactNumber" cssClass="help-block" element="em" />
   							</div>
   						</div>
   						
   						
   						<div class="form-group">
   							<label class="col-md-4 control-label" for="password">Password</label>
   							<div class="col-md-8">
   								<sf:input type="text" path="password" id="password" class="form-control" placeholder="Password"/>
   								<sf:errors path="password" cssClass="help-block" element="em" />
   							</div>
   						</div>
   						
   						<div class="form-group">
   							<label class="col-md-4 control-label" for="confirmPassword">Confirm Password</label>
   							<div class="col-md-8">
   								<sf:input type="text" path="confirmPassword" id="confirmPassword" class="form-control" placeholder="Re-enter Password"/>
   								<sf:errors path="confirmPassword" cssClass="help-block" element="em" />
   							</div>
   						</div>
   						
   						<div class="form-group">
   							<label class="col-md-4 control-label" for="password">Select Role</label>
   							<div class="col-md-8">
   							<label class="radio-inline">
   							<sf:radiobutton path="role" value="USER" checked="checked" /> User
   							</label>
   							<label class="radio-inline">
   							<sf:radiobutton path="role" value="SUPPLIER" /> Supplier
   							</label>
   							</div>
   						</div>
   						
   						<div class="form-group">
   							<div class="col-md-offset-4 col-md-8">
   							<button type="submit" name="_eventId_billing" class="btn btn-primary">
										Next - Billing <span class="glyphicon glyphicon-chevron-right"></span>
									</button>
   							</div>
   						</div>
   						
   						</sf:form>
   							
   						</div>
   					</div>
   					
   				</div>
   			</div>
   			
   			
   		</div>
    
		<%@ include file="../shared/flows-footer.jsp" %>