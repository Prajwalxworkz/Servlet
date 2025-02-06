 <%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html> 
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css
        "
    />
    <style>
      body {
        font-family: "Times New Roman", Times, serif;
        font-size: 15px;
      }
    </style>
  </head>
  <body>
    <div class="container my-5">
      <div class="text-center"><h3>Update Profile</h3></div>
      <div class="row justify-content-center my-5">
        <div class="col-lg-4">
          <form action="updateProfile" method="post">
            <div class="alert alert-success" role="alert">
              <h5>${updateMessage}</h5>
            </div>
            <input name="id" hidden value="${dto.getId()}" />
            <div>
              <label class="form-lable">First Name</label>
              <input class="form-control" type="text" name="firstName"  value="${dto.getFirstName()}"/>
            </div>
            <div>
              <label class="form-lable">Last Name</label>
              <input class="form-control" type="text" name="lastName" value="${dto.getLastName()}"/>
            </div>
            <div>
              <label class="form-lable">Password</label>
              <input class="form-control" type="password" name="password"  value="${dto.getPassword()}"/>
            </div>
            <div>
              <label class="form-lable">Email</label>
              <input class="form-control" type="email" name="email" value="${dto.getEmail()}"/>
            </div>

            <div>
                <label class="form-lable" >Gender</label><br>
                <input type="radio" name="gender" value="male"  ${dto.getGender()=='male'? 'checked="checked"' : ''}>
                <label class="form-lable" >Male</label><br>
                <input type="radio" name="gender" value="female" ${dto.getGender()=='female' ? 'checked="checked"': ''} >
                <label class="form-lable" >Female</label><br>
                <input type="radio" name="gender" value="others" ${dto.getGender()=='others'? 'checked="checked"':''} >
                <label class="form-lable" >Others</label>
            </div>
            <div class="my-3 d-grid d-md-block">
              <input class="btn btn-success" type="submit" value="Update Profile" />
            </div>
          </form>
        </div>
      </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js
        "></script>
  </body>
</html>
