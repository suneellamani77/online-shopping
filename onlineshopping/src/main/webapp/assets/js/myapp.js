
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
		
	default:
		$('#products').addClass('active');
		$('#a_'+menu).addClass('active');
		break;
	}
	
	
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
							
							if(row.quantity <1 ){
								str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';	
							}
							else{
								str += '<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
							}
							
							return str;
						}
					}
					
				]
			
			
		});
	
	
	}
	
});
