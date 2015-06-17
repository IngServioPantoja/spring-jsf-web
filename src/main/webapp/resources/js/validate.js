$(document).ready(function(){
	$(".soloNumero").keypress(function(event){
		if(event.keyCode < 48 || event.keyCode > 57){
			event.preventDefault();
		}
	});
});