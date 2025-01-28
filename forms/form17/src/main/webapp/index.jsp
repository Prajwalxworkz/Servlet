<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <style>
      body {
        font-family: Arial, Helvetica, sans-serif;
        font-size: 15px;
      }
      .form-container {
        background-color: cornflowerblue;
        border: 2px solid purple;
        border-radius: 7px;
        display: grid;
        grid-template-columns: 200px 1fr;
        gap: 15px 10px;
        padding: 10px;
      }

      input[type="text"],
      input[type="date"],
      input[type="password"],
      input[type="email"] {
        border-radius: 4px;
      }

      input[type="submit"] {
        padding: 7px;
        background-color: #007bff;
        color: white;
        border: none;
        border-radius: 4px;
        font-size: 14px;
        cursor: pointer;
      }
    </style>
  </head>
  <body>
    <div class="form-container">
      <form action="createAccount" method="post">
        <div>
          <label>Username</label>
          <input type="text" name="userName" />
        </div>

        <div>
          <label>Password</label>
          <input type="password" name="password" />
        </div>
        <div>
          <label>Confirm Password</label>
          <input type="password" name="confirmPassword" />
        </div>
        <div>
          <label>Email</label>
          <input type="text" name="email" />
        </div>
        <div>
          <label>Gender</label><br />
          <input type="radio" name="gender" />
          <label>Male</label><br />
          <input type="radio" name="gender" />
          <label>Female</label><br />
          <input type="radio" name="gender" />
          <label>Others</label>
        </div>
        <div>
          <br />
          <input type="submit" value="Create your Account" />
        </div>
      </form>
    </div>
  </body>
</html>
