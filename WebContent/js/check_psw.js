function check_psw(form){
	if(form.password.value!=form.rpassword.value){
		alert("password does not match!");
		form.rpassword.select();		
		return(false);
	}
	else{
		
		
	}
}


