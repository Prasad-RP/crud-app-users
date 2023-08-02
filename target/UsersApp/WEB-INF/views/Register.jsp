<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Register Form</title>
    <style>
      form {
        display: flex;
        flex-direction: column;
        align-items: center;
        margin: 50px auto;
        max-width: 500px;
        font-family: Arial, sans-serif;
      }
      
      label {
        margin-bottom: 10px;
        font-weight: bold;
      }
      
      input[type="text"], input[type="email"], input[type="password"] {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
        margin-bottom: 20px;
        font-size: 16px;
      }
      
      input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
      }
      
      input[type="submit"]:hover {
        background-color: #3e8e41;
      }
    </style>
  </head>
  <body>
  
  <h2>${Header}</h2>
    <form action="processform" method="post">
      <label for="name">Name:</label>
      <input type="text" id="name" name="name" required>
      
      <label for="email">Email:</label>
      <input type="email" id="email" name="email" required>
      
            <label for="address">Address:</label>
      <input type="text" id="address" name="address" required>
      
      
      
      <label for="password">Password:</label>
      <input type="password" id="password" name="password" required>
      
      <input type="submit" value="Submit">
    </form>
  </body>
</html>
