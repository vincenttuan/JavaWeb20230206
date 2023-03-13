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
						<form class="pure-form" method="POST" action="/JavaWeb/rest/user/${ id }">
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
											<th>ID</th><th>Name</th><th>Salary</th>
											<th><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 24 24"><path d="M0 0h24v24H0z" fill="none"/><path d="M9 16.2l3 3.01V22h-6v-2.79l3-3.01zM12 3c-4.41 0-8 3.59-8 8s3.59 8 8 8 8-3.59 8-8-3.59-8-8-8zm0 14c-3.31 0-6-2.69-6-6s2.69-6 6-6 6 2.69 6 6-2.69 6-6 6z"/></svg></th>
											<th><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 24 24"><path d="M0 0h24v24H0z" fill="none"/><path d="M7 8v11c0 .55.45 1 1 1h8c.55 0 1-.45 1-1V8H7zm2-6h6l1.48 2H8.52L9 2zm9 6H6v-2h12v2z"/></svg></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach varStatus="status" var="user" items="${ users }">
											<tr>
												<td>${ status.index }</td>
												<td>${ user.name }</td>
												<td>${ user.salary }</td>
												<td title="修改" style="cursor: pointer;"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 24 24"><path d="M0 0h24v24H0z" fill="none"/><path d="M9 16.2l3 3.01V22h-6v-2.79l3-3.01zM12 3c-4.41 0-8 3.59-8 8s3.59 8 8 8 8-3.59 8-8-3.59-8-8-8zm0 14c-3.31 0-6-2.69-6-6s2.69-6 6-6 6 2.69 6 6-2.69 6-6 6z"/></svg></td>
												<td title="刪除" style="cursor: pointer;"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 24 24"><path d="M0 0h24v24H0z" fill="none"/><path d="M7 8v11c0 .55.45 1 1 1h8c.55 0 1-.45 1-1V8H7zm2-6h6l1.48 2H8.52L9 2zm9 6H6v-2h12v2z"/></svg></td>
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