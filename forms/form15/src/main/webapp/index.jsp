<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        body{
           font-family: 'Times New Roman', Times, serif;
           font-size: 15px;
        }
        .form-container{
            background-color: ;
            border:2px solid purple ;
            border-radius: 7px;
            display: grid;
            grid-template-columns: 100px 1fr;
            gap: 15px 10px;

            padding: 10px;;
        }

       input[type="text"], input[type="email"], input[type="password"]{
        border-radius: 4px;
       }

       input[type="submit"] {
      padding: 7px;
      background-color: lightGreen;
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
        <form action="signUp" method="post">
            <div>
                <label>First Name</label>
                <input type="text" name="firstName">
            </div>
            <div>
                <label>Last Name</label>
                <input type="text" name= "lastName">
            </div>
            <div>
                <label>Password</label>
                <input type="password" name="password">
            </div>
            <div>
                <label>Confirm Password</label>
                <input type="password" name="confirmPassword">
            </div>
            <div>
                <label >Email</label>
                <input type="email" name="email">
            </div>

            <div>
                <label>Gender</label><br>
                <input type="radio" name="gender">
                <label >Male</label><br>
                <input type="radio" name="gender">
                <label >Female</label><br>
                <input type="radio" name="gender">
                <label >Others</label>
            </div>
            <div >
                <br>
                <input type="submit" value="Sign Up">
            </div>
        </form>
    </div>
</body>
</html>