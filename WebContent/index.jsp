<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>FollowMe</title>
<style type="text/css" title="currentStyle" media="screen">
		@import "css/style.css";
</style>
</head>

<body>

<div id="up">
</div>

<div id="main" >
</div>

<div id="lg">
    <script type="text/javascript" src="js/check_psw.js"></script> 
    <fieldset id="log"  >
    <form id="login" action="./user" method="post"> 
        <input type="text" id="username" name="username" size="32" placeholder="Username" autofocus required>
        <input type="password" name="password" size="22" placeholder="Password" required>
        <input type="submit" id="submit" value="Log in" style="color: #fff; background-color:#528ead">
        <a href="#" style="color:#666; font-size:14px">Forgot your password?</a>
    </form>
    </fieldset>
    
    <fieldset id="reg" >
     <form id="signup" action="./register" method="post" onsubmit="return check_psw(this)">
      <h4 style="color:#528ead">New Member? Sign Up</h4>
        <input type="text" name="username"  id="username" size="32" id="username" placeholder="Username" required />
        <script type="text/javascript" src="js/check_user.js"></script>
        <input type="text" name="email" size="32" id="email" placeholder="Email" required/>
        <input type="password" name="password" size="32" id="password" placeholder="Password" required/>
        <input type="password" name="rpassword" size="32" id="rpassword" placeholder="confirm password" required/>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="submit" id="reg" value="Start FollowMe" style="color:#fff; background-color:#528ead;"/>
    </form>
    </fieldset>
</div>

</body>
</html>
