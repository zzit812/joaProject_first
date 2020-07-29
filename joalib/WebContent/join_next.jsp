<%@ page language="java" contentType="text/html; charset= UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.*"%>
<%@ page import = "java.sql.*"%>
<%@ page import="com.joalib.DTO.member_DTO"%>
<%@ page import="com.joalib.DAO.DAO"%>
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
	//정보 받아오기
	member_DTO mDTO = new member_DTO();
    
    mDTO.setMember_id(request.getParameter("member_id"));
    mDTO.setMember_pw(request.getParameter("member_pw"));
    mDTO.setMember_name(request.getParameter("member_name"));    
    mDTO.setMember_tel(
    		request.getParameter("member_tel1")+request.getParameter("member_tel2")+request.getParameter("member_tel3")
    		);
    mDTO.setMember_birth(request.getParameter("member_birth"));
    mDTO.setMember_email(
    		request.getParameter("member_email_id")+"@"+request.getParameter("member_email_adress")
    		);
    mDTO.setMember_adress(
    		request.getParameter("address") + request.getParameter("detailAddress")
    		);
    mDTO.setMember_character(Integer.parseInt(request.getParameter("member_character")));
    mDTO.setMember_level("1");
    
 	//세션에 저장
    String member_name = request.getParameter("member_name");
    session.setAttribute("member_name",member_name);   
    
	%>
	<%		
		DAO dao = new DAO();
		DAO.getinstance();		
		request.setCharacterEncoding("UTF-8");
		dao.member_insert(mDTO);
		
		
		response.sendRedirect("join_3.jsp");
		
	%>



</body>
</html>
