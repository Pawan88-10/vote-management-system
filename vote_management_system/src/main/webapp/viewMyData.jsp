<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="voterView.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<title>User Login Page</title>
</head>
<body>
<section class="user">
        <div class="userForm">
            <i class="fa-regular fa-user usericon"></i><br>
            <h1>User Login</h1>
            <p>Welocme to the vote management System</p>
            <form action="userView" method="post">
            <i class="fa-solid fa-user-pen username"></i>
            <i class="fa-solid fa-envelope emailicon"></i>
            <i class="fa-solid fa-lock passwordicon"></i>
            <input type="text" class="name" name="username" placeholder="USERNAME">
            <input type="email" class="useremail" name="useremail" placeholder="USEREMAIL" required="required"><br>
            <input type="password" class="password" name="userpass" placeholder="PASSWORD" required="required"><br>
            <input type="radio" class="radio" name="selected" value="true" required="required"><span>remember me</span><br>
            <button type="submit">Login</button>
            </form>
        </div>
    </section>
</body>
</html>