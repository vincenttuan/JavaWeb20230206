<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
					<td>
						<form class="pure_form" method="POST">
							<fieldset>
								<legend>User Form</legend>
								
								<input type="hidden" name="_method" value="${ _method }">
								<button type="submit" class="pure-button pure-button-primary">${ _method }</button>
							</fieldset>
						</form>
					</td>
					<!-- User List -->
					<td>
						<form class="pure_form">
							<fieldset>
								<legend>User List</legend>
								
							</fieldset>
						</form>
					</td>
					<!-- User Chart -->
					<td>
						<form class="pure_form">
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