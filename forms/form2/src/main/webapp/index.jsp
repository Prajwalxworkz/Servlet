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
         .font-family{
            font-family: 'Times New Roman', Times, serif;
        }
    </style>
  </head>
  <body>
    <div class="container border font-family">
      <div class="text-center">
        <h3>Form 2</h3>
      </div>
      <div class="row justify-content-center my-5">
        <div class=" col-md-4">
          <form action="saveProfile" method="post">
            <div class="my-3">
              <label class="form-label">First Name:</label>
              <input
                class="form-control"
                type="text"
                name="firstName"
                id=""
                placeholder="Enter fisrt name"
              />
            </div>
            <div class="my-3">
                <label class="form-label">Last Name:</label>
              <input
                class="form-control"
                type="text"
                name="lastName"
                id=""
                placeholder="Enter last name"
              />
            </div>
            <div class="my-3">
                <label class="form-label">Date Of Birth:</label>
              <input class="form-control" type="date" name="dob" id="" />
            </div>
            <div class="my-3">
                <label class="form-label">Email:</label>
              <input
                type="email"
                class="form-control"
                name="email"
                placeholder="name@gmail.com"
              />
            </div>
            <div class="my-3">
                <label class="form-label">Gender</label><br />
              <input type="radio" name="gender" value="male" id="" />
              <label class="form-label" for="male">Male</label> &nbsp;
              <input type="radio" name="gender" value="female" id="" />
              <label class="form-label" for="female">Female</label> &nbsp;
              <input type="radio" name="gender" value="others" id="" />
              <label class="form-label" for="others">Others</label>
            </div>
            <div class="my-3">
                <label for="" class="form-label">Address</label>
              <input type="text" name="address" id="" class="form-control" />
            </div>
        <div class="d-grid mx-5 my-5">
            <button class="btn btn-primary " type="submit" value="Save Profile">Save Profile</button>
        </div>
           <div class="d-grid mx-5 my-5">
             <a class="btn btn-primary" href="getAllProfiles">Get All Profiles</a>
            </div>
          </form>
        </div>
      </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js
    "></script>
  </body>
</html>
