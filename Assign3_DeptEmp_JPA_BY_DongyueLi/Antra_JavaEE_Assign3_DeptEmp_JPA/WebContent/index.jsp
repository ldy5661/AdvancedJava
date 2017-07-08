<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
<title>Hello</title>
</head>
<body>
	<div class = "container">
		<div class = "row" style = "margin: 10%;">
			<div class = "col">
				<h1 class = "text-center">Login</h1>
			</div>
		</div>
		<c:if test = "${invalidUser}">
			<div class ="row">
				<div class ="col">
					<p class = "text-danger text-center">Incorrect User Name or Password</p>
				</div>
			</div>
		</c:if>
		<form action="/Antra_JavaEE_Assign3_DeptEmp_JPA/login" method="post">
			<div class="form-group row justify-content-md-center">
				<label for="userName" class="col-2 col-form-label">User Name:</label>
				<div class="input-group col-3">
					<div class="input-group-addon">
						<span class="glyphicon glyphicon-user"></span>
					</div>
					<input class="form-control" type="text" placeholder="Enter Username" id="userName" name = "userName"required>		
				</div>
			</div>
			<div class="form-group row justify-content-md-center">
				<label for="password" class="col-2 col-form-label">Password:</label>
				<div class="input-group col-3">
					<div class="input-group-addon">
						<span class="glyphicon glyphicon-lock"></span>
					</div>
					<input class="form-control" type="password" placeholder="Enter Password" id="password" name = "password" required>
				</div>
			</div>
			<div class="form-group row justify-content-md-center" style = "margin: 5%;">
				<div class="col-2">
					<button type="submit" class="btn btn-success">Login</button>
				</div>
				<div class="col-2">
					<button type="reset" class="btn btn-danger">Reset</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>