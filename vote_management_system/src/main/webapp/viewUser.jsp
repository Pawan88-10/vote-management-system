<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="voterView.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<title>Admin Login Page</title>
</head>
<body>
<!-- &nbsp;    // Regular space
&ensp;    // Two spaces gap
&emsp;   // Four spaces gap -->

<section class="admin">
	<img src="./images/coding_image.gif" alt="coding-image">
	<div class="admin_form">
	<form action="adminView" method="post">
	<h1>Admin Login</h1>
	<input type="text" name="admin_name" placeholder="Admin name" required="required"><br>
	<input type="password" class="password" name="admin_pass" placeholder="&bull; &#8226; &#x2022; &bull; &#8226; &#x2022; &bull; &#8226;" required="required"><br>
	<input type="checkbox" name="check" class="checkbox" value="true" required="required"><span>Remember &emsp; Forgot Password</span><br>
	<input type="submit" class="btn" value="VIEW USER">
	</form>
	</div>
</section>
</body>
</html>