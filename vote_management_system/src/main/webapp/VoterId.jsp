<%@page import="java.net.ResponseCache"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="entity.classes.User"%>
<%@page import="java.sql.*"%>
<%@ page import="java.util.*" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="voterView.css">
<style type="text/css">
	@font-face {
    font-family: KrutiDev;
    src: url(./language/Kruti Dev 010 Regular.ttf);
}
</style>
<title>Voter Id</title>
</head>
<body>

<%
	String name = (String)request.getAttribute("name");
	String fname = (String)request.getAttribute("father");
	String gender = (String)request.getAttribute("gender");
	String date = (String)request.getAttribute("date");

	response.setContentType("text/html");
%>
<section class="voterid">
	<div class="id_card">
	<nav>
	<img src="./images/indiaLogo.png" alt="india logo">
	<h1 style="font-family: krutiDev">भारत निर्वाचन आयोग</h1><br>
	<h1 class="eng">Election Commission Of India</h1><br>
	<h2>मतदाता फोटो पहचान पत्र Electo Photo Identity Card</h2>
	</nav>
	<header>
	<img src="./images/voterid.png" alt="user id">
	<h1>
	<img src="./images/barcode.png" alt="barcode">
	DG78N90O88
	</h1>
	</header>
	<footer>
	<h1>निर्वाचक का नाम  <span class="nirvachak sim">:</span> <%= name %></h1>
	<h1>Elector's Name <span class="elector sim">:</span><%= name  %> </h1>
	<h1>पिता का नाम  <span class="father sim">:</span> <%= fname  %></h1>
	<h1>Father's Name <span class="father1 sim">:</span> <%= fname  %> </h1>
	<h1>लिंग/Sex <span class="gender sim">:</span> <%= gender %></h1>
	<h1>जन्म की तारीख/आयु  <span class="age sim">:</span> <%= date  %></h1>
	<h1>Date Of Birth/Age <span class="date sim">:</span> <%= date  %> </h1>
	
	</footer>
	</div>
	
	<%
    Boolean isFetchingData = (Boolean)request.getAttribute("isFetchingData");
    // Default to false if attribute is not set
    if (isFetchingData == null) {
        isFetchingData = false;
    }
	%>

	<% if (!isFetchingData) { %>
    <div class="update">
        <h1><a href="VoterCard.jsp">Update Something</a></h1>
    </div>
	<% } %>
	
	</section>
</body>
</html>