<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>LOGOUT</title>
</head>
<body>
	<%
	session.invalidate();
	response.sendRedirect("board.jsp");	//<�ӽ�> home���� �̵�
	%>
</body>
</html>