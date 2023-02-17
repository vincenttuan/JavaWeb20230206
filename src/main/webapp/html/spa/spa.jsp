<%@page import="spa.entity.Master"%>
<%@page import="spa.entity.Spa"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
	List<Spa> spaList = (List<Spa>)request.getAttribute("spaList");
	List<Master> masterList = (List<Master>)request.getAttribute("masterList");
%>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="/JavaWeb/css/pure-min.css">
		<link rel="stylesheet" href="/JavaWeb/css/button-style.css">
		<title>Spa Page</title>
	</head>
	<body style="padding: 20px">
		
		<form class="pure-form" method="post" action="/JavaWeb/servlet/bmi">
			<fieldset>
				<legend>Spa 預約</legend>
				姓名: <input type="text" placeholder="請輸入名字" id="userName" name="userName"><p>
				SPA: <select id="spaId" name="spaId">
						<% for(Spa spa : spaList) { %>
							<option id="<%=spa.getId() %>"><%=spa.getName() %></option>
						<% } %>
					 </select><p>
				師傅: <select id="masterId" name="masterId">
						<% for(Master master : masterList) { %>
							<option id="<%=master.getId() %>"><%=master.getName() %></option>
						<% } %>
					 </select><p>
				日期: <input type="date" id="spaTime" name="spaTime"><p>					 	 
				<button type="reset" class="pure-button button-secondary">清除</button>
				<button type="submit" class="pure-button pure-button-primary">預約</button>
			</fieldset>
		</form>
		
	</body>
</html>