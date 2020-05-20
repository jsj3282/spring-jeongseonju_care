<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<table border="1" style="width:500px;">
		<caption><h1>로 그 게 시 판</h1></caption>
			<tr><th>번호</th><th>로그</th></tr>
			<c:forEach items="${logs }" var="log">
				<tr>
					<td>${log.num }</td>
					<td>${log.logdate }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>