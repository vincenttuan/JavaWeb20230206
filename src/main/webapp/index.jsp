<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index Page</title>
</head>
<body>
	Hello 我的 Jsp Page: <%=new Date() %>
	<ol>
		<li><a href="/JavaWeb/servlet/report">Report Servlet</a></li>
		<li><a href="/JavaWeb/servlet/time">Time Servlet</a></li>
		<li><a href="/JavaWeb/servlet/spa">Spa Servlet</a></li>
	</ol>
</body>
</html>