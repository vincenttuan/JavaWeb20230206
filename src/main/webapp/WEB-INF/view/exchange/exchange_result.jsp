<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Exchange Result</title>
		<link rel="stylesheet" href="/JavaWeb/css/pure-min.css">
		<link rel="stylesheet" href="/JavaWeb/css/button-style.css">
	</head>
	<body style="padding: 20px">
		
		<form class="pure-form" method="get" action="/JavaWeb/exchange">
			<fieldset>
				<legend>Exchange Result</legend>
				
				${ amount } ${ symbols[0] } 可兌換 ${ total } ${ symbols[1] }: <p>
				
				<button type="submit" class="pure-button pure-button-primary">返回</button>
			</fieldset>
		</form>
		
	</body>
</html>