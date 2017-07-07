<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
<title>Hello ${userName}</title>
</head>
<body>
	<c:choose>
		<c:when test="${not empty invalidUser and !invalidUser }">
			<div class="container">
				<div class="row justify-content-end" style="margin: 5%;">
					<div class="col-1">
						<a href="/Antra_JavaEE_Assign2_DeptEmp_JDBC/logout"
							class="btn btn-info btn-lg"> <span
							class="glyphicon glyphicon-log-out"></span>Logout
						</a>
					</div>
				</div>
				<div class="row">
					<div class="col">
						<h1 class="text-center text-warning">Welcome ${userName}</h1>
					</div>
				</div>
				<div class="row">
					<div class="col">
						<h3 class="text-center" style = "margin-bottom: 2%;">Add New Department</h3>
					</div>
				</div>
				<form action="/Antra_JavaEE_Assign2_DeptEmp_JDBC/addDept" method="post">
					<div class="form-group row justify-content-md-center">
						<label for="deptName" class="col-2 col-form-label">Department Name:</label>
						<div class="col-3">
							<input class="form-control" type="text" placeholder="Enter DeptName" id="deptName" name="deptName" required>
						</div>
					</div>
					<div class="form-group row justify-content-md-center">
						<label for="deptEmail" class="col-2 col-form-label">Department Email:</label>
						<div class="col-3">
							<input class="form-control" type="email" placeholder="Enter DeptEmail" id="deptEmail" name="deptEmail" required>
						</div>
					</div>
					<div class="form-group row justify-content-md-center"
						style="margin: 2%;">
						<div class="col-2">
							<button type="submit" class="btn btn-success">
								<span class="glyphicon glyphicon-ok"></span> Save
							</button>
						</div>
						<div class="col-2">
							<a href="/Antra_JavaEE_Assign2_DeptEmp_JDBC/loggedin" class="btn btn-danger">
								<span class="glyphicon glyphicon-remove"></span> Cancel
							</a>
						</div>
					</div>
				</form>
				<c:if test="${not empty deptList}">
					<div class="row">
						<div class="col">
							<h4 class="text-center">Existing Department List</h4>
						</div>
					</div>
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Department ID</th>
								<th>Department Name</th>
								<th>Department Email</th>
								<th>Employee</th>						
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${deptList}" var="dept">
								<tr>
									<td>${dept.id}</td>
									<td>${dept.name }</td>
									<td>${dept.email }</td>
									<td>
										<c:forEach items="${dept.empList}" var="emp">
										<table>
											<tr>
												<td>${emp.firstName} ${emp.lastName} ${emp.age}</td>
											</tr>										
										</table>
										</c:forEach>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
			</div>
		</c:when>
		<c:otherwise>
			<div class="container">
				<div class="row">
					<div class="col">
						<h3 class = "text-danger text-center" style = "margin-top: 10%;">Please Log in first. <a href="/Antra_JavaEE_Assign2_DeptEmp_JDBC">Log in</a></h3>
					</div>
				</div>		
			</div>
		</c:otherwise>
	</c:choose>
</body>
</html>