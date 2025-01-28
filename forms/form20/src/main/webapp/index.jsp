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
            background-color: #FFFFFF
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
        <form action="apply" method="post">
            <div>
                <label>First Name</label>
                <input type="text" name="firstName">
            </div>
            <div>
                <label>Last Name</label>
                <input type="text" name= "lastName">
            </div>
            <div>
                <label >Email</label>
               <input type="text" name="email">
           </div>
            <div>
                <label>Highest Education</label>
                <input type="text" name= "education">
            </div>


            <div>
                <label >Phone Number</label>
                <input type="text" name="phNum">
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
            <div>
                <label >Address</label>
                <input type="text" name="address">
            </div>
            <div>
                <label >Resume</label>
                <input type="file" name="resume" accept="accept">
            </div>
            <div >
                <br>
                <input type="submit" value="Apply">
            </div>
        </form>
    </div>
</body>
</html>