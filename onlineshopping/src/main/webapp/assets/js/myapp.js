
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
	
});
