<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link
    rel="stylesheet"
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css
  "
  />
</head>
<body>
    <div class="table-responsive-md">
        <table class="table table-hover  table-border-color table-striped">
        <thead>
            <tr>
                <th scope="col">Sl No.</th>
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
                <th scope="col">Dob</th>
                <th scope="col">Email</th>
                <th scope="col">Gender</th>
                <th scope="col">Address</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${dtoList}" var="dto" varStatus="status">
            <tr>
                <td scope="row">${status.count}</td>
                <td>${dto.getFirstName()}</td>
                <td>${dto.getLastName()}</td>
                <td>${dto.getDob()}</td>
                <td>${dto.getEmail()}</td>
                <td>${dto.getGender()}</td>
                <td>${dto.getAddress()}</td>
              <td><a href="delete?id=${dto.getId()}"><img src="https://img.icons8.com/?size=25&id=7837&format=png&color=000000" alt="Delete"></a> &nbsp;
                                 <a href="getProfile?id=${dto.getId()}"><img src="https://img.icons8.com/?size=25&id=49&format=png&color=000000" alt="Update"></a>
                             </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js
    "></script>
</body>
</html>
