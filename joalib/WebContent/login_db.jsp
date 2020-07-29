<%@ page language="java" contentType="text/html; charset= UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*"%>
<%@ page import = "com.joalib.login.action.*"%>
<% request.setCharacterEncoding("UTF-8");%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <%
    request.setCharacterEncoding("UTF-8");

    String member_id = request.getParameter("member_id");
    String member_pw = request.getParameter("member_pw");
    
    login_check login = new login_check();
    
    String pw = login.idCheck(member_id);
    
    if(pw != null){
    	//가져온 pw와 member_pw가 동일한지 확인해야함
    	//out.println("<script>alert('환영합니다.');history.back();</script>");
    	if(pw.equals(member_pw)){
    		session.setAttribute("member_id",member_id);
    		session.setAttribute("member_pw",member_pw);
    		//out.println("<script>alert('환영합니다');history.back();</script>");
    		response.sendRedirect("mypage_main.jsp");
    	}else{
    		out.println("<script>alert('가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.');history.back();</script>");
    	}
    	
    }else{
    	out.println("<script>alert('가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.');history.back();</script>");
    }
    
    %>
</body>
</html>
