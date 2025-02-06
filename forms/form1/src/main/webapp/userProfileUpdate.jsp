<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css
    "
    />
    <title>Document</title>
    <style>
        .font-family{
            font-family: 'Times New Roman', Times, serif;
        }
    </style>
  </head>
  <body>
    <div class="container border ">
      <div class="text-center">
        <h4>MAX</h4>
        <p class="lead">Fasion is my Passion</p>
      </div>
      <h2>${updatedMessage}</h2>
      <div class="row justify-content-center my-5">
        <div class="col-lg-4">
          <form action="updateProfile" method="post">
            <div class="font-family ">
            <input type="text"
            hidden
            name="id"
            value="${userDto.getId()}"
            />
              <div>
                <lable class="form-lable" for="userName">UserName:</lable>
                <input
                  class="form-control"
                  type="text"
                  name="userName"
                  id="userName"
                  placeholder="e.g David"
                  value="${userDto.getFullName()}"
                />
              </div>
              <div>
                <lable class="form-lable" for="email">Email:</lable>
                <input
                  class="form-control"
                  type="email"
                  name="email"

                  id="email"
                  placeholder="name@gmail.com"
                   value="${userDto.getEmail()}"
                />
              </div>
              <div>
                <label class="form-lable" for="mobile">Mobile</label>
                <input
                  class="form-control"
                  type="number"
                  name="mobile"
                  id="mobile"
                   value="${userDto.getMobile()}"
                />
              </div>
              <div>
                <label class="form-lable" for="address"
                  >Address</label
                >
                <input
                  class="form-control"
                  type="text"
                  name="address"
                  id="address"
                   value="${userDto.getAddress()}"
                />
              </div>
              <!-- <div>
                <label class="form-lable" for="aboutYou">About you</label>
                <textarea
                  class="form-control"
                  name="aboutYou"
                  id="aboutYou"
                  cols="30"
                  rows="10"
                  placeholder="Write about yourself"
                ></textarea>
              </div> -->
              <div class="d-grid my-3 mx-5">
                <button class="btn btn-primary" type="submit" value="Update Profile">
                  Update Profile
                </button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js
    "></script>
  </body>
</html>
