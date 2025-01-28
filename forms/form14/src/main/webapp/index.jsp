<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <style>
          .form-container{
              display: grid;
              grid-template-columns: 100px 1fr;
              gap: 15px 10px;
              max-width: 400px;
          }

         input[type="text"],
         input[type="dob"],
         input[type="email"],
         input[type="password"]
         {
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
  <div>
    <form action="createAccount" method="post">
      <label for="">UserName</label>
      <input type="text" name="userName">
      <br>
      <label for="">Email</label>
      <input type="email" name="email">
      <br>
      <label for="">City</label>
      <input type="text" name="city" >
      <br>
      <label for="">Password</label>
      <input type="password" name="password">
      <br>
      <label for="">Confirm Password</label>
      <input type="password" name = "confirmPassword">
      <br>
      <input type="submit" value="Create Account">
    </form>
  </div>

</body>
</html>