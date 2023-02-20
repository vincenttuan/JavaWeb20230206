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
	<body style="padding: 0px">
		<!-- Banner  -->
		<img src="/JavaWeb/image/spa_banner.jpg">
		
		<!-- Spa Table -->
		<table style="padding: 20px">
			<tr>
				<td valign="top">
					<!-- Spa 預約 -->
					<%@include file="/WEB-INF/view/spa/spa_reserve.jspf" %>
				</td>
				<td valign="top">
					<!-- Spa 產品說明 -->
					<form class="pure-form">
						<fieldset>
							<legend>Spa 產品說明</legend>
							<table class="pure-table pure-table-bordered">
								<thead>
									<tr>
										<th>編號</th>
										<th>名稱</th>
										<th>說明</th>
										<th>分鐘</th>
										<th>價格</th>
									</tr>
								</thead>
								<tbody>
									<% for(Spa spa : spaList) { %>
									<tr>
										<td align="center"><%=spa.getId() %></td>
										<td><%=spa.getName() %></td>
										<td><%=spa.getContent() %></td>
										<td align="center"><%=spa.getTime() %></td>
										<td align="right">$<%=spa.getPrice() %></td>
									</tr>
									<% } %>
								</tbody>
							</table>
						</fieldset>
					</form>
				</td>
			</tr>
		</table>
		
	</body>
</html>