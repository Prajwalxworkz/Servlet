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
        background-color: whitesmoke;
        border: 2px solid ;
        border-radius: 7px;
        display: grid;
        grid-template-columns: 100px 1fr;
        gap: 15px 10px;
        max-width: 400px;
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
      <form action="pay" method="post">
        <div>
          <label>Username</label>
          <input type="text" name="userName" />
        </div>
        <div>
          <label>Account Number</label>
          <input type="text" name="accountNumber" />
        </div>
        <div>
          <label>IFSCode</label>
          <input type="text" name="ifsCode" />
        </div>
        <div>
          <label>Amount</label>
          <input type="text" name="amount" />
        </div>
        <div>
           <label>Phone Number</label>
            <input type="text" name="phNum" />
        </div>
        <div>
          <br />
          <input type="submit" value="Create your Account" />
        </div>
      </form>
    </div>
  </body>
</html>
