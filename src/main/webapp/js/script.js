//https://krazytech.com/programs/java-registration-page-using-servlet-mysql-mvc
function validate()
{
	var email = document.form.email.value;
	var username = document.form.username.value;
	var password = document.form.password.value;
	var confirm_password= document.form.confirm_password.value;
	
	if (username==null || username==="")
	{
		alert("Username can't be blank");
		return false;
	}
	else if (email==null || email==="")
	{
		alert("Email can't be blank");
		return false;
	}
	else if(password.length<6)
	{
		alert("Password must be at least 6 characters long.");
		return false;
	}
	else if (password!==confirm_password)
	{
		alert("Confirm Password should match with the Password");
		return false;
	}
}