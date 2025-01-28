<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Online Payment</title>
      <style>
            body{
               font-family: 'Times New Roman', Times, serif;
               font-size: 15px;
            }
            .form-container{
                background-color: white;
                border:2px solid purple ;
                border-radius: 7px;
                display: grid;
                grid-template-columns: 200px 1fr;
                gap: 15px 10px;
                padding: 10px;;
            }

           input[type="text"],input[type="email"], input[type="password"]{
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
    <form action="apply" method="post">
        First Name  : <input type="text" name="fName"><br>
        <br>
        Last Name  : <input type="text" name="lName"><br>
        <br>
        Date of Birth : <input type="text" name="dob"><br>
        <br>
        Email Id : <input type="text" name="email"><br>
        <br>
        Address : <input type="text" name="address"><br>
        <br>
        <input type="submit" value="apply">
    </form>
</div>
</body>
</html>