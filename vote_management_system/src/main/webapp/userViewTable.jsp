<%@page import="entity.classes.User"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="voterView.css">
<title>User View Table</title>
</head>
<body>
<section>

    <%
    
    // Retrieve the list of users from request attribute
    Object obj = request.getAttribute("users"); 
    
    // Check if obj is not null and is actually a list
    if (obj != null && obj instanceof List) {
        List<User> userList = (List<User>) obj;
    %>
    <div class="viewTable">
        <h1>User Data (Part Time Employee)</h1>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Password</th>
                <th>Address</th>
                <th>Age</th>
                <th>Gender</th>
                <th>Father's Name</th>
                <th>Mother's Name</th>
                <th>Date</th>
                <th colspan="3">Features</th>
            </tr>
            
            <!-- Iterate over each user in the userList -->
            <% for (User user : userList) { %>
                <tr>
                    <td><%= user.getId() %></td>
                    <td><%= user.getName() %></td>
                    <td><%= user.getEmail() %></td>
                    <td><%= user.getPassword() %></td>
                    <td><%= user.getAddress() %></td>
                    <td><%= user.getAge() %></td>
                    <td><%= user.getGender() %></td>
                    <td><%= user.getFatherName() %></td>
                    <td><%= user.getMotherName() %></td>
                    <td><%= user.getDate() %></td>
                    <td><a href="addUser.jsp">Add User</a></td>
                     <td><a href="removeUser?userId=<%= user.getId() %>">Remove</a></td>
                    <td><a href="VoterId?userdata=<%=user.getId()%>">Voter Id</a></td>
                    
                </tr>
            <% } %>
            
        </table>
    </div>
    <% } else { %>
        <p>No user data available.</p>
    <% } %>
</section>
</body>
</html>