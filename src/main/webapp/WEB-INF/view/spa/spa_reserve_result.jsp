<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="/JavaWeb/css/pure-min.css">
		<link rel="stylesheet" href="/JavaWeb/css/button-style.css">
		<title>Spa Reserve Result Page</title>
	</head>

	<body style="padding: 0px">
		<!-- Banner  -->
		<img src="/JavaWeb/image/spa_banner.jpg">
		<!-- 本次預約單  -->
		<div style="padding: 20px">
			<form class="pure-form">
				<fieldset>
					<legend>本次預約單</legend>
					<table class="pure-table pure-table-bordered">
						<thead>
							<tr>
								<th>預約單號</th>
								<th>預約人</th>
								<th>SPA 商品 ID</th>
								<th>SPA 時間</th>
								<th>SPA 價格</th>
								<th>師傅 ID</th>
								<th>預約時間</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${ order.id }</td>
								<td>${ order.userName }</td>
								<td>${ order.spaId }</td>
								<td>${ order.spaTime }</td>
								<td>${ order.spaPrice }</td>
								<td>${ order.masterId }</td>
								<td>${ order.reserve }</td>
							</tr>
						</tbody>
					</table>
				</fieldset>
			</form>
		</div>
		<!-- 歷史預約單  -->
		<div style="padding: 20px">
			<form class="pure-form">
				<fieldset>
					<legend>歷史預約單</legend>
					<table class="pure-table pure-table-bordered">
						<thead>
							<tr>
								<th>預約單號</th>
								<th>預約人</th>
								<th>SPA 商品 ID</th>
								<th>SPA 時間</th>
								<th>SPA 價格</th>
								<th>師傅 ID</th>
								<th>預約時間</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="order" items="${ orderList }">
								<tr>
									<td>${ order.id }</td>
									<td>${ order.userName }</td>
									<td>${ order.spaId }</td>
									<td>${ order.spaTime }</td>
									<td>${ order.spaPrice }</td>
									<td>${ order.masterId }</td>
									<td>${ order.reserve }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</fieldset>
			</form>
		</div>
		
	</body>
</html>