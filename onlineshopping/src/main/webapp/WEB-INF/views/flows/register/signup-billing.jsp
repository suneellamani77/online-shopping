<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ include file="../shared/flows-header.jsp" %>
<div class="container">

	<div class="row">

		<div class="col-md-offset-3 col-md-6">
			
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Sign Up - Adrress</h4>
				</div>
				
				<div class="primary-body">
					
					<sf:form method="POST" id="billingForm" class="form-horizontal" modelAttribute="billing">
						
						<div class="form-group">
							<label class="col-md-4 control-label" for="addressLineOne">Address Line One</label>
							<div class="col-md-8">
							<sf:input type="text" path="addressLineOne" placeholder="Enter Address Line One" class="form-control" />
							<sf:errors path="addressLineOne" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-4 control-label" for="addressLineTwo">Address Line Two</label>
							<div class="col-md-8">
							<sf:input type="text" path="addressLineTwo" placeholder="Enter Address Line Two" class="form-control" />
							<sf:errors path="addressLineTwo" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-4 control-label" for="city">City</label>
							<div class="col-md-8">
							<sf:input type="text" path="city" placeholder="Enter City Name" class="form-control" />
							<sf:errors path="city" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-4 control-label" for="postalCode">Postal Code</label>
							<div class="col-md-8">
							<sf:input type="text" path="postalCode" placeholder="Enter Postal Code" class="form-control" />
							<sf:errors path="postalCode" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-4 control-label" for="state">State</label>
							<div class="col-md-8">
							<sf:input type="text" path="state" placeholder="Enter State Name" class="form-control" />
							<sf:errors path="state" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-4 control-label" for="country">Country</label>
							<div class="col-md-8">
							<sf:input type="text" path="country" placeholder="Enter Country Name" class="form-control" />
							<sf:errors path="country" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
							<!-- Submit the button for moving to the personal -->
							<button type="submit" class="btn btn-primary" name="_eventId_personal" >
							<span class="glyphicon glyphicon-chevron-left"></span> Previous - Personal 
							</button>
							
							<!-- Submit the button for moving to the confirm -->
							<button type="submit" class="btn btn-primary" name="_eventId_confirm" >
							Next - Confirm <span class="glyphicon glyphicon-chevron-right"></span>
							</button>
							</div>
						</div>
					
					</sf:form>
					
				</div>
			</div>
		</div>

	</div>

</div>

<%@ include file="../shared/flows-footer.jsp"%>