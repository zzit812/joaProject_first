<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="db_table_dao.DAO" %>
<% request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	
	DAO dao = new DAO();
	DAO.getinstance();
	dao.board_del();
	out.println("<script>alert('삭제되었습니다'); location.href='board.jsp'</script>");
	%>
	
	
</body>

</html>