<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div
	style="display: flex;
	justify-content: center;
	align-items: center;
	margin-top: 50px;
	position: relative;"
	
	class="error">
		<img src="./images/error.jpg" height="600px;" alt="Error Page">
	
		<a style="position: absolute;
		top: 24rem; left: 38.6rem;azimuth: color : blue;
		font-size: 25px;font-weight:bolder; text-decoration-line: none;
		color: transparent;
		" href="viewUser.jsp">OK</a>
		<a style="position: absolute;
		top: 24rem; right: 37rem;azimuth: color : blue;
		font-size: 27px; text-decoration-line: none;
		color: transparent;
		"
	   href="voter_view.jsp">Cancel</a>
	   
	   <a style="position: absolute;
		top: 11.3rem; right: 32rem;azimuth: color : blue;
		font-size: 29px; width : 35px;
		font-weight:bolder; text-decoration-line: none;
		color: transparent;
		"
	   href="voter_view.jsp">X</a>
	</div>
	
</body>
</html>