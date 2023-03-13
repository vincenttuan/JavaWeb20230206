<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>User Form</title>
		<link rel="stylesheet" href="/JavaWeb/css/pure-min.css">
		<link rel="stylesheet" href="/JavaWeb/css/button-style.css">
	</head>
	<body style="padding: 0px">
		<div style="height: 130px; background-image: url('/JavaWeb/image/user_banner.png'); background-position: right center; background-size: contain; background-repeat: no-repeat; background-color: #333;"></div>
		<div style="height: 20px; background-color: #E76054;"></div>
		
		<div style="padding: 20px">
			
			<table>
				<tr>
					<!-- User Form -->
					<td valign="top">
						<form class="pure-form" method="POST" action="/rest/user/${ id }">
							<fieldset>
								<legend>User Form</legend>
								序號: <input type="text" id="id" name="id" value="${ id }" readonly><p>
								姓名: <input type="text" placeholder="請輸入姓名" id="name" name="name" required><p>
								薪資: <input type="number" placeholder="請輸入薪資" id="salary" name="salary" required><p>
								<input type="hidden" name="_method" value="${ _method }">
								<button type="reset" class="pure-button button-secondary">RESET</button>
								<button type="submit" class="pure-button button-success">${ _method }</button>
							</fieldset>
						</form>
					</td>
					<!-- User List -->
					<td valign="top">
						<form class="pure-form">
							<fieldset>
								<legend>User List</legend>
								<table class="pure-table pure-table-bordered">
									<thead>
										<tr>
											<th>ID</th><th>Name</th><th>Salary</th><th>Update</th><th>Delete</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach varStatus="status" var="user" items="${ users }">
											<tr>
												<td>${ status.index }</td>
												<td>${ user.name }</td>
												<td>${ user.salary }</td>
												<td>update</td>
												<td>delete</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</fieldset>
						</form>
					</td>
					<!-- User Chart -->
					<td valign="top">
						<form class="pure-form">
							<fieldset>
								<legend>User Chart</legend>
								
							</fieldset>
						</form>
					</td>
				</tr>
			</table>
			
			
		</div>
	
	</body>
</html>