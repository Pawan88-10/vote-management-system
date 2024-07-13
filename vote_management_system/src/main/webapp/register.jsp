<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="voterView.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<title>Register</title>
</head>
<body>
<section>
<div style="background-color: orange; 
			box-shadow: box-shadow: rgba(0, 0, 0, 0.17) 0px -23px 25px 0px inset,
			rgba(0, 0, 0, 0.17) 0px -53px 45px 0px inset,
			rgba(0, 0, 0, 0.17) 0px -37px 65px 0px inset;
			border-radius : 15px;
			"
			class="voterCard">
	<h1>Information</h1>
	<form action="usertableView" method="post">
	<label for="votername">Voter Name : </label>
	<input type="text" name="votername" class="votername" required="required"><br>
	<label for="voteremail">Email : </label>
	<input type="email" name="email" class="voteremail" required="required"><br>
	<label for="voterpass">Password :</label>
	<input type="password" name="pass" class="voterpass"><br>
	<label for="voteraddress">Voter Address : </label>
	<input type="text" name="voteraddress" class="voteraddress" required="required"><br>
	<label for="voterage" id="age">Age : </label>
	<input type="number" name="voterage" class="voterage" ><br>
	<label for="votergender" id="gender">Gender : </label>
	<input type="radio" name="gender" value="male" class="male" required>Male
	<input type="radio" name="gender" value="female" class="female">Female 
	<input type="radio" name="gender" value="other" class="other">Other <br>
	<label for="father">Father Name : </label>
	<input type="text" name="father" class="father" required="required"><br>
	<label for="mother">Mother Name : </label>
	<input type="text" name="mother" class="mother" required="required"><br>
	<label for="birth" id="birth">D.O.B : </label>
	<input type="date" name="birth" class="birth" required="required"><br>
	<button style="cursor: pointer" type="submit">Register</button>
	</form>
</div>
</section>
</body>
</html>