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
                background-color: burlywood;
                border:2px solid purple ;
                border-radius: 7px;
                display: grid;
                grid-template-columns: 100px 1fr;
                gap: 15px 10px;
                max-width: 400px;
                max-height: 700p;
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
    <form action="pay" method="post">
        User Name : <input type="text" name="userName"><br>
        <br>
        Phone Number : <input type="text" name="phoneNumber"><br>
        <br>
        Account Type : <input type="text" name="type"><br>
        <br>
        Account Number : <input type="text" name="account"><br>
        <br>
        Amount Rs : <input type="text" name="amount"><br>
        <br>
        <input type="submit" value="Pay">
    </form>
</div>
</body>
</html>