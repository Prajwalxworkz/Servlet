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

       input[type="text"]{
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
        <form action="addProfile" method="post">
            <div>
                <label>Full Name</label>
                <input type="text" name="fullName">
            </div>
            <div>
                <label >Email</label>
                <input type="text" name="email">
            </div>
            <div>
                <label >Moblie</label>
                <input type="text" name="mobile">
            </div>
            <div>
                <label >Address</label>
                <input type="text" name="address">
            </div>
            <div >
                <br>
                <input type="submit" value="Add Profile">
            </div>
        </form>
    </div>
</body>
</html>