<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="/JavaWeb/css/pure-min.css">
		<link rel="stylesheet" href="/JavaWeb/css/button-style.css">
		<title>Person Preview</title>
	</head>
	<body style="padding: 20px">
		<form class="pure-form" method="post" action="/JavaWeb/servlet/person_save">
			<fieldset>
				<legend>會員資料預覽</legend>
				姓名: <p>
				年齡: <p>
				姓別: <p>
				生日: <p>
				學歷: <p>
				興趣: <p>
				備註: <p>	 	 
				<button type="button"
						onclick="window.location.href='/JavaWeb/html/person.html';" 
						class="pure-button button-secondary">返回</button>
				<button type="submit" class="pure-button pure-button-primary">儲存</button>
			</fieldset>
		</form>
		
	</body>
</html>