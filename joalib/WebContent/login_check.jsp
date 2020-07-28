
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	
	String member_id = null;
	member_id = (String)session.getAttribute("member_id");
	
	if ( member_id != null) {
		//로그인이 되어있음
			response.sendRedirect("mypage_main.jsp");	//마이페이지		
	}else{
		//로그인이 안됨
		out.print("<script>alert('로그인 후 이용가능합니다.');location.href='login_1.html'</script>");
	}
	
	%>
</body>
</html>