
$(document).ready(function(){
	
	
	switch (menu) {
	case 'All Products':
		$('#products').addClass('active');
		break;
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
		
	case 'Home':
		$('#home').addClass('active');
		break;
		
	case 'Manage Products':
		$('#manageproducts').addClass('active');
		break;
		
	default:
		$('#products').addClass('active');
		$('#a_'+menu).addClass('active');
		break;
	}
	
	//------ to tackle the csrf token ------
	var token = $('meta[name="_csrf"]').attr('content');
	var header = $('meta[name="_csrf_header"]').attr('content');
	
	if(token.length > 0 && header.length >0){
		// set the token header for ajax header
		
		$(document).ajaxSend(function(e, xhr, options){
			xhr.setRequestHeader(header,token);
		});
	}
	
	
	//////////////////////
	var $table=$('#productListTable');
	
	if($table.length){
		
		var jsonUrl='';
		if(window.categoryId==''){
			jsonUrl =window.contextRoot +'/json/data/all/products';
		}
		else{
				jsonUrl =window.contextRoot +'/json/data/category/'+window.categoryId +'/products';
		}
		
		
		
		$table.DataTable({
			lengthMenu :[[3,5,9,-1],['3 Records','5 Records','9 Records','ALL']],
			pageLength:5,
			
			ajax: {
				
				url : jsonUrl,
				dataSrc:'',
			},
				
				columns:[
					
					{
						data:'code',
						mRender : function(data,row,type) {
							return '<image src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg" />';
						}
					},
					{
						data:'name'
					},
					{
						data:'brand'
					},
					{
						data:'unitPrice',
						mRender : function(data,row,type) {
							return '&#8377; '+data;
						}
					},
					{
						data:'quantity',
						
						mRender : function(data,row,type) {
							
							if(data<1){
								return '<span style="color:red">out of stack!!</span>';
							}
							return data;
						}
						
					},
					{
						data:'id',
						mRender : function(data, type, row) {
							
							
							var str='';
							
							
							str += '<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';
							
							if(userRole == 'ADMIN'){
								str += '<a href="'+window.contextRoot+'/manage/'+data+'/product" class="btn btn-warning"><span class="glyphicon glyphicon-edit"></span></a>';
							}
							else{
							
							if(row.quantity <1 ){
								str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';	
					
							}
							else{
									str += '<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
							}
							}
							return str;
						}
					}
					
				]
			
			
		});
	
	
	}
	
	/////////////// alert
	
	var $alert=$('.alert');
	if($alert.length){
		setTimeout(function() {
			$alert.fadeOut('slow');
		},3000);
	}
	
	
	/////////////////////////////////////////////////
	
	$('.switch input[type="checkbox"]').on('change', function() {
		
		var checkbox=$(this);
		var checked=checkbox.prop('checked');
		var dMsg = (checked) ? 'You Want to activate the product?' :
								'You want to deactivate the product?';
		var value=checkbox.prop('value');
		
		bootbox.confirm({
			size :'medium',
			title:'Product Activation and Deactivation',
			message : dMsg,
			
			callback : function(confirmed) {
				if(confirmed){
					
					console.log(value);
					bootbox.alert({
						size:'medium',
						title:'Information',
						message : 'You are going to perform operation on product '+value
					});
				}
				else{
					checkbox.prop('checked',!checked);
				}
			
			}
		});
		
	});
	
	
	///////////////////////////////////////////////
	
var $adminProducutsTable=$('#adminProducutsTable');
	
	if($adminProducutsTable.length){
		
		var jsonUrl=window.contextRoot +'/json/data/admin/all/products';
		
		$adminProducutsTable.DataTable({
			lengthMenu :[[10,30,50,-1],['10 Records','30 Records','50 Records','ALL']],
			pageLength:10,
			
			ajax: {
				
				url : jsonUrl,
				dataSrc:'',
			},
				
				columns:[
					{
						data:'id'
					},
					{
						data:'code',
						mRender : function(data,row,type) {
							return '<image src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="adminDataTableImg" />';
						}
					},
					{
						data:'name'
					},
					{
						data:'brand'
					},
					{
						data:'quantity',
						
						mRender : function(data,row,type) {
							
							if(data<1){
								return '<span style="color:red">out of stack!!</span>';
							}
							return data;
						}
						
					},
					{
						data:'unitPrice',
						mRender : function(data,row,type) {
							return '&#8377; '+data;
						}
					},
					
					{
						data:'active',
						bSortable : false,
						mRender : function(data, type, row) {
							
							
							var str='';
							
							str +='<label class="switch">';
							if(data){
							str +='<input type="checkbox" checked="checked" value="'+row.id+'">';
							}
							else{
								str +='<input type="checkbox" value="'+row.id+'">';
							}
							str +='<div class="slider"></div></label>';
							
							return str;
						}
					},
					
					{
						data :'id',
						bSortable : false,
						mRender : function(data,type,row) {
							return '<a href="'+window.contextRoot+'/manage/'+data+'/product" class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></a>'
						}
					}
					
				],
				
				initComplete : function() {
					var api=this.api();
					api.$('.switch input[type="checkbox"]').on('change', function() {
						
						var checkbox=$(this);
						var checked=checkbox.prop('checked');
						var dMsg = (checked) ? 'You Want to activate the product?' :
												'You want to deactivate the product?';
						var value=checkbox.prop('value');
						
						bootbox.confirm({
							size :'medium',
							title:'Product Activation and Deactivation',
							message : dMsg,
							
							callback : function(confirmed) {
								if(confirmed){
									
									var activationUrl=window.contextRoot+'/manage/product/'+value+'/activation';
									
									$.post(activationUrl, function(data) {
										bootbox.alert({
											size:'medium',
											title:'Information',
											message : data
										});
									});
									
								}
								else{
									checkbox.prop('checked',!checked);
								}
							
							}
						});
						
					});
					
				}
			
			
		});
	
	
	}
	
	//////////// Jquery Validation for category ///
	var $categoryForm=$('#categoryForm');
	
	if($categoryForm.length){
		console.log('validation');
		
		$categoryForm.validate({
			
			rules:{
				name:{
					required : true,
					minlength : 2
				},
				
				description :{
					required : true
				}
			},
			
			messages :{
				name:{
					required : 'Please add the Category Name!',
					minlength : 'The category name should not be less than 2 charecters'
				},
				
				description : {
					required : 'Please add a Description for this Category !',
				}
			},
			errorElement : 'em',
			errorPlacement : function(error, element) {
				// add the class of help-block
				error.addClass('help-block');
				
				error.insertAfter(element);
			}
			
			
		});
	}
	
	
	
////////////Jquery Validation for Login ///
	var $loginForm=$('#loginForm');
	
	if($loginForm.length){
		
		$loginForm.validate({
			
			rules:{
				username:{
					required : true,
					email : true
				},
				
				password :{
					required : true
				}
			},
			
			messages :{
				username:{
					required : 'Please enter the username!',
					email : 'Please enter the valid email address'
				},
				
				password : {
					required : 'Please enter the password  !',
				}
			},
			errorElement : 'em',
			errorPlacement : function(error, element) {
				// add the class of help-block
				error.addClass('help-block');
				
				error.insertAfter(element);
			}
			
			
		});
	}
	
});
