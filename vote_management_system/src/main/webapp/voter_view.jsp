<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="voterView.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<title>Vote Management System</title>
</head>
<body>

<section>
	<div class="Adminlayout">
	<i class="fa-solid fa-user-secret"></i><br>
	<a href="viewUser.jsp" target="_top">Admin Login</a>
	<p>View your account and limits</p>
	</div>
	
	<div class="UserLayout">
	<i class="fa-solid fa-user"></i><br>
	<a href="viewMyData.jsp" target="_top">User Login</a>
	<p>Invite,remove and manage users</p>
	<p>If you don't have any account, <a style="font-size: 17px; color: wheat; font-family: serif;" href="register.jsp">Register</a></p>
	</div>
</section>
		
</body>
</html>