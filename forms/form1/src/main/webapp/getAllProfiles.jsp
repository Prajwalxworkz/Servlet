<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <html>
 <head>
 <title>W3.CSS</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
 </head>
 <body>

 <div class="w3-container w3-striped">
   <h2>User Details Table</h2>

   <table class="w3-table w3-striped">
     <tr>
       <th>Sl No.</th>
       <th>Full Name</th>
       <th>Email</th>
       <th>Phone Number</th>
       <th>Address</th>
       <th>Action</th>
     </tr>
    <c:forEach items="${ dtoList}" var="dto"  varStatus="status">
     <tr>

           <td>${status.count}</td>
           <td>${dto.getFullName()}</td>
           <td>${dto.getEmail()}</td>
           <td>${dto.getMobile()}</td>
           <td>${dto.getAddress()}</td>
           <td><a href="delete?id=${dto.getId()}">Delete</a> &nbsp;<a href="getProfile?id=${dto.getId()}">Update</a></td>
      </tr>
    </c:forEach>
   </table>
 </div>
 </body>
 </html>